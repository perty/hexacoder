package se.artcomputer.edu.hexacoder.adapter.in.rest.cart;

import se.artcomputer.edu.hexacoder.model.cart.CartLineItem;
import se.artcomputer.edu.hexacoder.model.money.Money;
import se.artcomputer.edu.hexacoder.model.product.Product;

public record CartLineItemWebModel(
        String productId, String productName, Money price, int quantity) {

    public static CartLineItemWebModel fromDomainModel(CartLineItem lineItem) {
        Product product = lineItem.product();
        return new CartLineItemWebModel(product.id().value(),
                product.name(),
                product.price(),
                lineItem.quantity().value());
    }
}