package se.artcomputer.edu.hexacoder.model.cart;

import se.artcomputer.edu.hexacoder.model.customer.CustomerId;
import se.artcomputer.edu.hexacoder.model.money.Money;
import se.artcomputer.edu.hexacoder.model.product.Product;
import se.artcomputer.edu.hexacoder.model.product.ProductId;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final CustomerId id;

    private final Map<ProductId, CartLineItem> lineItems = new LinkedHashMap<>();

    public Cart(CustomerId id) {
        this.id = id;
    }

    public void addProduct(Product product, Quantity quantity) throws NotEnoughItemsInStockException {
        if (product.itemsInStock() < quantity.value()) {
            throw new NotEnoughItemsInStockException(
                    ("Product %s has less items in stock (%d) "
                            + "than the requested total quantity (%d)")
                            .formatted(product.id(), product.itemsInStock(), quantity.value()),
                    product.itemsInStock());
        }
        lineItems.put(product.id(), new CartLineItem(product, quantity));
    }

    public List<CartLineItem> lineItems() {
        return List.copyOf(lineItems.values());
    }

    public int numberOfItems() {
        return lineItems.values().stream().mapToInt(CartLineItem::quantityAsInt).sum();
    }

    public Money subTotal() {
        return lineItems.values().stream()
                .map(CartLineItem::subTotal)
                .reduce(Money::add)
                .orElse(null);
    }
}
