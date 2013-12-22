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
        }
      "With only Import Tax" in {
        val item = new Item(10.00, true,true)
        item.taxes() should be equalTo(.50)
        }
      "With only Regular Tax" in {
        val item = new Item(10.00, false,false)
        item.taxes() should be equalTo(1.00)
      }
      "And With Both Taxes" in {
        val item = new Item(10.00, false,true)
        item.taxes() should be equalTo(1.50)
      }
     }
  }
}