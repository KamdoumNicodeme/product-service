package dev.hexa.productservice.application.port.secondary;

import dev.hexa.productservice.domain.model.Product;

import java.util.Optional;

public interface ProductPersistencePort {
    Product save(Product product);
    Optional<Product> findById(Long id);
    void deleteById(Long id);
}
