package se.artcomputer.edu.hexacoder.model.cart;

import org.junit.jupiter.api.Test;
import se.artcomputer.edu.hexacoder.model.product.Product;
import se.artcomputer.edu.hexacoder.model.product.TestProductFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static se.artcomputer.edu.hexacoder.model.money.TestMoneyFactory.euros;

class CartTest {

  @Test
  void givenEmptyCart_addTwoProducts_numberOfItemsAndSubTotalIsCalculatedCorrectly() throws NotEnoughItemsInStockException {
    Cart cart = TestCartFactory.emptyCartForRandomCustomer();

    Product product1 = TestProductFactory.createTestProduct(euros(12, 99));
    Product product2 = TestProductFactory.createTestProduct(euros(5, 97));

    cart.addProduct(product1, new Quantity(3));
    cart.addProduct(product2, new Quantity(5));

    assertEquals(8, cart.numberOfItems());
    assertEquals(euros(68, 82), cart.subTotal());
  }

  // more tests

}