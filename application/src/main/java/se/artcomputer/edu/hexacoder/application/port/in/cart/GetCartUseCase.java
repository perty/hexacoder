package se.artcomputer.edu.hexacoder.application.port.in.cart;

import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;

public interface GetCartUseCase {

  Cart getCart(CustomerId customerId);
}