package test

import org.specs2.mutable._
import main.scala.Item
/**
 * Created with IntelliJ IDEA.
 * User: howens
 * Date: 12/20/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 * Tests the ability of an item to calculate proper tax
 */

class ItemSpecification extends Specification {
  "A Item" should {
    "return the proper tax cost" >> {
      "With No taxes" in {
          val item = new Item(10.00, true,false)
          item.costWithTaxes() should be equalTo(10.00)
        }
      "With only Import Tax" in {
        val item = new Item(10.00, true,true)
        item.costWithTaxes() should be equalTo(10.50)
        }
      "With only Regular Tax" in {
        val item = new Item(10.00, false,false)
        item.costWithTaxes() should be equalTo(11.00)
      }
      "And With Both Taxes" in {
        val item = new Item(10.00, false,true)
        item.costWithTaxes() should be equalTo(11.50)
      }
     }
  }
}