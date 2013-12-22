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
          item.taxes() should be equalTo(0.0)
          item.costWithTaxes() should be equalTo(10.00)
        }
      "With only Import Tax" in {
        val item = new Item(10.00, true,true)
        item.taxes() should be equalTo(.50)
        item.costWithTaxes() should be equalTo(10.50)
      }
      "With only Regular Tax" in {
        val item = new Item(10.00, false,false)
        item.taxes() should be equalTo(1.00)
        item.costWithTaxes() should be equalTo(11.00)
      }
      "And With Both Taxes" in {
        val item = new Item(10.00, false,true)
        item.taxes() should be equalTo(1.50)
        item.costWithTaxes() should be equalTo(11.50)
      }
     }
    "And with rounding" >> {
      "With No Taxes"  in {
        val item = new Item(12.49, true, false)
        item.taxes() should be equalTo (0.0)
        item.costWithTaxes() should be equalTo (12.49)
      }
      "With only Import Tax" in {
        val item = new Item(11.25, true, true)
        item.taxes() should be equalTo (0.60)
        item.costWithTaxes() should be equalTo (11.85)
      }
      "With only Regular Tax" in {
        val item = new Item(18.99, false, false)
        item.taxes() should be equalTo (1.90)
        item.costWithTaxes() should be equalTo (20.89)
      }
      "And With Both Taxes" in {
        val item = new Item(27.99, false,true)
        item.taxes() should be equalTo(4.20)
        item.costWithTaxes() should be equalTo(32.19)
      }
    }
  }
}