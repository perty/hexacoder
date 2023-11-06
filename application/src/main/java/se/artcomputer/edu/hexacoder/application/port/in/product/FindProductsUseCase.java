package se.artcomputer.edu.hexacoder.application.port.in.product;

import se.artcomputer.edu.hexacoder.model.product.Product;

import java.util.List;

public interface FindProductsUseCase {

  List<Product> findByNameOrDescription(String query);
}