package se.artcomputer.edu.hexacoder.application.service.cart;

import se.artcomputer.edu.hexacoder.application.port.in.cart.AddToCartUseCase;
import se.artcomputer.edu.hexacoder.application.port.out.persistence.CartRepository;
import se.artcomputer.edu.hexacoder.application.port.out.persistence.ProductRepository;
import se.artcomputer.edu.hexacoder.application.service.product.ProductNotFoundException;
import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.cart.NotEnoughItemsInStockException;
import se.artcomputer.edu.hexacoder.model.cart.Quantity;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;
import se.artcomputer.edu.hexacoder.model.product.Product;
import se.artcomputer.edu.hexacoder.model.product.ProductId;

import java.util.Objects;

public class AddToCartService implements AddToCartUseCase {

  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  public AddToCartService(CartRepository cartRepository, ProductRepository productRepository) {
    this.cartRepository = cartRepository;
    this.productRepository = productRepository;
  }

  @Override
  public Cart addToCart(CustomerId customerId, ProductId productId, Quantity quantity)
      throws ProductNotFoundException, NotEnoughItemsInStockException {
    Objects.requireNonNull(customerId, "'customerId' must not be null");
    Objects.requireNonNull(productId, "'productId' must not be null");

    Product product =
        productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

    Cart cart =
        cartRepository
            .findByCustomerId(customerId)
            .orElseGet(() -> new Cart(customerId));

    cart.addProduct(product, quantity);

    cartRepository.save(cart);

    return cart;
  }
}