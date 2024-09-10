package dev.hexa.productservice.infrastructure.adapters.primary.mapper;

import dev.hexa.productservice.domain.model.Product;
import dev.hexa.productservice.infrastructure.adapters.primary.model.ProductCreateRequest;
import dev.hexa.productservice.infrastructure.adapters.primary.model.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRequestMapper {

    Product toProduct(ProductCreateRequest request);
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponseList(List<Product> products);
}
