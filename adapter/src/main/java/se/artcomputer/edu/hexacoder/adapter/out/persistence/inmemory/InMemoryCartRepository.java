package se.artcomputer.edu.hexacoder.adapter.out.persistence.inmemory;

import se.artcomputer.edu.hexacoder.application.port.out.persistence.CartRepository;
import se.artcomputer.edu.hexacoder.model.cart.Cart;
import se.artcomputer.edu.hexacoder.model.customer.CustomerId;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCartRepository implements CartRepository {

    private final Map<CustomerId, Cart> carts = new ConcurrentHashMap<>();

    @Override
    public void save(Cart cart) {
        carts.put(cart.id(), cart);
    }

    @Override
    public Optional<Cart> findByCustomerId(CustomerId customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

//    @Override
//    public void deleteById(CustomerId customerId) {
//        carts.remove(customerId);
//    }
}