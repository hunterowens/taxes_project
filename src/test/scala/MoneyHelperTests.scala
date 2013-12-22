package test

import org.specs2.mutable._
import main.scala.MoneyHelpers
/**
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/20/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 * Tests the ability of an item to calculate proper tax
 */

class MoneyHelperSpecification extends Specification {
  "MoneyHelpers" should {
    "Get Decimals Correctly" in {
      val moneyHelp = new MoneyHelpers
      moneyHelp.getDecimal(19.99) should be equalTo(.99)
    }
    "Add Numbers Correctly" >> {
      "when 99 cents with one" in {
        val moneyHelp = new MoneyHelpers
        moneyHelp.addMoney(1.99,1.00) should be equalTo(2.99)
        moneyHelp.addMoney(1.00,1.99) should be equalTo(2.99)
      }
      "When Both 99 Cents" in {
        val moneyHelp = new MoneyHelpers
        moneyHelp.addMoney(9.99,9.99) should be equalTo(19.98)
      }
      "when not 99 cent" in {
        val moneyHelp = new MoneyHelpers
        moneyHelp.addMoney(1.00,1.00) should be equalTo(2.00)
      }
    }
  }
}