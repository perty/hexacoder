package se.artcomputer.edu.hexacoder.model.cart;

import se.artcomputer.edu.hexacoder.model.money.Money;
import se.artcomputer.edu.hexacoder.model.product.Product;

public record CartLineItem(Product product, Quantity quantity) {

    public Money subTotal() {
        return product.price().multiply(quantity.value());
    }

    public int quantityAsInt() {
        return quantity.value();
    }
}
