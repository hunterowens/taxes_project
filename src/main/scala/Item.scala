package main.scala

/** Item Class
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/20/13
 * Time: 12:35 PM
 * This class implements an item for the Socrata coding challenge
 * each item has an associated cost with taxes that is calculated
  * @param cost
  * @param isExempt
  * @param isImported
 */
class Item(cost: Double, isExempt: Boolean, isImported: Boolean) {
  private val regTaxRate: Double = .1
  private val importDuty: Double = .05
  //Rounds to the nearest value to .05
  private def roundUp(x:Double):Double = {
    val withCents = x / 100
    val rounded = (scala.math.ceil(x * 20)) / 20
    val withoutCents = x * 100
    return withoutCents
  }
  private var costNoCents = (cost * 100).toInt
  // item   tax cost.
  // This would be an ideal place to implement pattern matching, maybe
  def taxes(): Double =  {
    var tax = 0.0
    if (isImported && !isExempt) //Both Imported and not Exempt:: Max Tax
      tax = roundUp(costNoCents * importDuty) + roundUp(costNoCents * regTaxRate)
    else if (!isExempt) //Just Reg Tax Rate
      tax = roundUp(costNoCents * regTaxRate)
    else if (isImported) //Just import duty
      tax = roundUp(costNoCents * importDuty)
    return tax / 100
  }
  def costWithTaxes(): Double = {
    (costNoCents + this.taxes()) / 100
  }
}
