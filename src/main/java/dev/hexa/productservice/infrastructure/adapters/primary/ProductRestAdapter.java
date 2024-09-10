package dev.hexa.productservice.infrastructure.adapters.primary;

import dev.hexa.productservice.application.port.primary.ProductServicePort;
import dev.hexa.productservice.infrastructure.adapters.primary.mapper.ProductRequestMapper;
import dev.hexa.productservice.infrastructure.adapters.primary.model.ProductCreateRequest;
import dev.hexa.productservice.infrastructure.adapters.primary.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductRestAdapter {

    private final ProductServicePort productService;
    private final ProductRequestMapper mapper;

    @PostMapping("/new")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductCreateRequest request){

        return ResponseEntity.status(HttpStatus.OK).body(mapper.toProductResponse(productService.ajouterProduit(mapper.toProduct(request))));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductCreateRequest request){
        return mapper.toProductResponse(productService.modifierProduit(id, mapper.toProduct(request)));
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return mapper.toProductResponse(productService.checherProduit(id));
    }
}
