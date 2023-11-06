package se.artcomputer.edu.hexacoder.application.port.out.persistence;

import se.artcomputer.edu.hexacoder.model.product.Product;
import se.artcomputer.edu.hexacoder.model.product.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  List<Product> findByNameOrDescription(String query);

  Optional<Product> findById(ProductId productId);
}