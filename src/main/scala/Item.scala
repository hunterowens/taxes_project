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
  private val nearest: Double = .05
  //Rounds to the nearest value as prescribed in nearest
  private def round_nearest(x:Double):Double = {
    return scala.math.round((x / nearest)) * nearest
  }
  // item cost with  taxes.
  // This would be an ideal place to implement pattern matching, maybe
  def taxes(): Double =  {
    if (isImported && !isExempt) //Both Imported and not Exempt:: Max Tax
      return round_nearest(cost * importDuty) + round_nearest(cost * regTaxRate)
    else if (!isExempt) //Just Reg Tax Rate
      return round_nearest(cost * regTaxRate)
    else if (isImported) //Just import duty
      return round_nearest(cost * importDuty)
    else
      return 0.0
  }
}
