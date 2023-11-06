package se.artcomputer.edu.hexacoder.application.port.out.persistence;

import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;

import java.util.Optional;

public interface CartRepository {

  void save(Cart cart);

  Optional<Cart> findByCustomerId(CustomerId customerId);
}