package com.aethos.aethosmarket.domain.repository;

import com.aethos.aethosmarket.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getALL();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
