/**
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/21/13
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
import scala.io.Source


object GenerateReceipts {
  def main(args: Array[String])= {
    if(args.length>0) {
      for(line<-Source.fromFile(args(0)).getLines())
       println(line.length+" "+line)
    }
    else
      Console.err.println("Please enter filename")
  }
}

