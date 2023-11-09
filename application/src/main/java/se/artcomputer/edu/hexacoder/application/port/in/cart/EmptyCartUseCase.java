package se.artcomputer.edu.hexacoder.application.port.in.cart;

import se.artcomputer.edu.hexacoder.model.customer.CustomerId;

public interface EmptyCartUseCase {

  void emptyCart(CustomerId customerId);
}