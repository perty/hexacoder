package se.artcomputer.edu.hexacoder.application.port.in.cart;

import se.artcomputer.edu.hexacoder.application.service.product.ProductNotFoundException;
import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.cart.NotEnoughItemsInStockException;
import se.artcomputer.edu.hexacoder.model.cart.Quantity;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;
import se.artcomputer.edu.hexacoder.model.product.ProductId;

public interface AddToCartUseCase {

  Cart addToCart(CustomerId customerId, ProductId productId, Quantity quantity) throws NotEnoughItemsInStockException, ProductNotFoundException;

}