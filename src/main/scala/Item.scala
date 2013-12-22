package main.scala

/** Item Class
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/20/13
 * Time: 12:35 PM
 * This class implements an item for the Socrata coding challenge
 * each item has an associated cost with taxes that is calculated
 * It takes advantage of the fact that it is easier to represent money
  * as an int rather than a double/float, where the something like
  * 9.99 + 9.99 does not equal 19.98
  * @param cost
  * @param isExempt
  * @param isImported
 */
class Item(cost: Double, isExempt: Boolean, isImported: Boolean) {
  private val regTaxRate: Int = 10
  private val importDuty: Int = 20
  //The No Decimal version
  private val costNoCents = scala.math.rint(cost * 100).toInt
  //Rounds to the nearest value to .05
  private def roundUp(x:Double):Int = {
    val modVal = x % 10
    var retVal = x
    modVal match {
      case 1 => retVal = x + 4
      case 2 => retVal = x + 3
      case 3 => retVal = x + 2
      case 4 => retVal = x + 1
      case 5 => retVal = x + 0
      case 6 => retVal = x + 4
      case 7 => retVal = x + 3
      case 8 => retVal = x + 2
      case 9 => retVal = x + 1
      case 0 => retVal = x + 0
    }
    retVal.toInt
  }
  // item   tax cost.
  // This would be an ideal place to implement pattern matching, maybe
  //Returns multiple of 100 (no cents)
  def taxes(): Int =  {
    var tax = 0.0
    if (isImported && !isExempt) //Both Imported and not Exempt:: Max Tax
      tax = roundUp(costNoCents / importDuty) + roundUp(costNoCents / regTaxRate)
    else if (!isExempt) //Just Reg Tax Rate
      tax = roundUp(costNoCents / regTaxRate)
    else if (isImported) //Just import duty
      tax = roundUp(costNoCents / importDuty)
    tax.toInt
  }
  //Returns multiple of 100 (no cents)
  def costWithTaxes(): Int = {
    (costNoCents + this.taxes()).toInt
  }
}
