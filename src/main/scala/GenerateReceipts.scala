/**
 * This Object contains the main method
 * It parses and calculates the outputs given the input
 * Has some issues with Side effect programm
 * as a command line argument
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/21/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 * @note Some side effects are present in this code, which shouldn't
 *       happen
 */
import scala.io.Source
import main.scala.Item

object GenerateReceipts {
  val exempt = List("book","chocolate","pill")
  var firstBasket = true
  //Init the counters
  var sum = 0.0
  var taxes = 0.0
  def main(args: Array[String])= {
    if(args.length>0) { // Gets File to Load Inputs
      for(line<-Source.fromFile(args(0)).getLines()) {
        var cleanLine = line.toLowerCase  //Lower case everything
        //B/c Matching issues
        if (cleanLine.contains("input")) {
          var outputString = cleanLine.replace("input","Output")
          if (firstBasket) {
            firstBasket = false
            println(outputString)
          }
          else  {
            println("Sales Taxes: " + taxes.toString)
            println("Total Cost: " + sum.toString)
            println(outputString)
            //reset counters
            sum = 0.0
            taxes = 0.0
          }
        }
        // This is when not an other case
        // Ignores Blank Lines, does
        // No other serious input validation
        else {
          if (!cleanLine.isEmpty()) {
              var lineArray = cleanLine.split(" ")
              val quantity = lineArray{0}.toInt //Get Number of Items
              val cost = lineArray.last.toDouble  //Gets the Cost of the Item
              val isImported = cleanLine.contains("imported") //Does the string imported show up
              //Is the Item exempt from Sales Tax
              var isExempt = false
              for (x <- exempt)
                if (cleanLine.contains(x)) isExempt = true
              val item = new Item(cost,isExempt,isImported)
              val taxLine = cleanLine.replace(cost.toString, item.costWithTaxes().toString)
              println(taxLine)
              taxes += (item.taxes() * quantity)
              sum += (item.costWithTaxes() * quantity)
          }
        }
      }
      // Print the taxes for the last loop
      println("Sales Taxes: " + (taxes / 100).toString)
      println("Total Cost:" + (sum / 100).toString)
    }
    else
      Console.err.println("Please enter filename")
  }
}

