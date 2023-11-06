package se.artcomputer.edu.hexacoder.application.service.cart;

import se.artcomputer.edu.hexacoder.application.port.in.cart.GetCartUseCase;
import se.artcomputer.edu.hexacoder.application.port.out.persistence.CartRepository;
import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;

import java.util.Objects;

public class GetCartService implements GetCartUseCase {

  private final CartRepository cartRepository;

  public GetCartService(CartRepository cartRepository) {
    this.cartRepository = cartRepository;
  }

  @Override
  public Cart getCart(CustomerId customerId) {
    Objects.requireNonNull(customerId, "'customerId' must not be null");

    return cartRepository
        .findByCustomerId(customerId)
        .orElseGet(() -> new Cart(customerId));
  }
}