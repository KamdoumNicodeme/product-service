package dev.hexa.productservice.infrastructure.adapters.secondary.persistence.repository;

import dev.hexa.productservice.infrastructure.adapters.secondary.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
