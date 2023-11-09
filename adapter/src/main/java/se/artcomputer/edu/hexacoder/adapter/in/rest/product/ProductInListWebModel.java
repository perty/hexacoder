package se.artcomputer.edu.hexacoder.adapter.in.rest.product;

import se.artcomputer.edu.hexacoder.model.money.Money;
import se.artcomputer.edu.hexacoder.model.product.Product;

public record ProductInListWebModel(String id,
                                    String name,
                                    Money price,
                                    int itemsInStock) {

  public static ProductInListWebModel fromDomainModel(Product product) {
    return new ProductInListWebModel(
        product.id().value(), product.name(), product.price(), product.itemsInStock());
  }
}