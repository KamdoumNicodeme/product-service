package dev.hexa.productservice.infrastructure.adapters.secondary.persistence;

import dev.hexa.productservice.application.port.secondary.ProductPersistencePort;
import dev.hexa.productservice.domain.model.Product;
import dev.hexa.productservice.infrastructure.adapters.secondary.persistence.mapper.ProductPersistenceMapper;
import dev.hexa.productservice.infrastructure.adapters.secondary.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistencePort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper mapper;

    @Override
    public Product save(Product product) {
        return mapper.toProduct(productRepository.save(mapper.toProductEntity(product)));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(mapper::toProduct);
    }

    @Override
    public void deleteById(Long id) {

        productRepository.deleteById(id);
    }
}
