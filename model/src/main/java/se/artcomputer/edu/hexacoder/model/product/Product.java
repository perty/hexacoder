package se.artcomputer.edu.hexacoder.model.product;

import se.artcomputer.edu.hexacoder.model.money.Money;

public record Product(
        ProductId id,
        String name,
        String description,
        Money price,
        int itemsInStock
) {

}
