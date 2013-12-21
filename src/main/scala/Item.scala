package main.scala

/**
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/20/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Item {
  private val regTaxRate: Double = .1
  private val importDuty: Double = .05
  private val nearest: Double = .05
  var cost: Double
  var isExempt: Boolean
  var isImported: Boolean
  var totalCost: Double
  //Rounds to the nearest value as prescribed in nearest
  private def round_nearest(x:Double):Double = {
    return scala.math.round((x / nearest)) * nearest
  }
  // Creates the amount of taxes. Currently does not implement rounding
  // This would be an ideal place to implement pattern matching, maybe
  def costWithTaxes(): Double =  {
    totalCost = cost
    if (isImported && !isExempt) //Both Imported and not Exempt:: Max Tax
      totalCost += round_nearest(cost * importDuty) + round_nearest(cost * regTaxRate)
    else if (!isExempt) //Just Reg Tax Rate
      totalCost += round_nearest(cost * regTaxRate)
    else if (isImported) //Just import duty
      totalCost += round_nearest(cost * importDuty)
    return totalCost
  }
}
