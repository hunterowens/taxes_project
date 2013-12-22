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
          item.taxes() should be equalTo(0)
          item.costWithTaxes() should be equalTo(1000)
        }
      "With only Import Tax" in {
        val item = new Item(10.00, true,true)
        item.taxes() should be equalTo(50)
        item.costWithTaxes() should be equalTo(1050)
      }
      "With only Regular Tax" in {
        val item = new Item(10.00, false,false)
        item.taxes() should be equalTo(100)
        item.costWithTaxes() should be equalTo(1100)
      }
      "And With Both Taxes" in {
        val item = new Item(10.00, false,true)
        item.taxes() should be equalTo(150)
        item.costWithTaxes() should be equalTo(1150)
      }
     }
    "And with rounding" >> {
      "With No Taxes"  in {
        val item = new Item(12.49, true, false)
        item.taxes() should be equalTo (00)
        item.costWithTaxes() should be equalTo (1249)
      }
      "With only Import Tax" in {
        val item = new Item(11.25, true, true)
        item.taxes() should be equalTo (60)
        item.costWithTaxes() should be equalTo (1185)
      }
      "With only Regular Tax" in {
        val item = new Item(18.99, false, false)
        item.taxes() should be equalTo (190)
        item.costWithTaxes() should be equalTo (2089)
      }
      "And With Both Taxes" in {
        val item = new Item(27.99, false,true)
        item.taxes() should be equalTo(420)
        item.costWithTaxes() should be equalTo(3219)
      }
    }
  }
}