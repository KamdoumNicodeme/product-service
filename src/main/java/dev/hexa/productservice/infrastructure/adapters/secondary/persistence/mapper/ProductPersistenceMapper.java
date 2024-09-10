package dev.hexa.productservice.infrastructure.adapters.secondary.persistence.mapper;

import dev.hexa.productservice.domain.model.Product;
import dev.hexa.productservice.infrastructure.adapters.secondary.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductPersistenceMapper {

    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity productEntity);
    List<Product> toProductEntityList(List<ProductEntity> product);

}
