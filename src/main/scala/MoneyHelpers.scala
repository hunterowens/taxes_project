package main.scala

/**
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/22/13
 * Time: 12:40 AM
 * To change this template use File | Settings | File Templates.
 */
class MoneyHelpers {
  //Functions to get sum
  //Helper functions to add cost, avoid .99 cent error
  //Hacky way to get decimal
  def getDecimal(x:Double):Double = {
    val numString = x.toString
    val decimalStringArray = numString.split('.')
    return decimalStringArray{1}.toDouble / 100
  }
//  //Adds money and avoid the 99 cent error
//  // this is overly verbose and bad
//  def addMoney(x:Double,y:Double):Double = {
//   if (getDecimal(x) + getDecimal(y) > 1.0) {
//
//   }

}
