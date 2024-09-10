package dev.hexa.productservice.application;

import dev.hexa.productservice.application.annotation.DomainServiceAnnotation;
import dev.hexa.productservice.application.port.primary.ProductServicePort;
import dev.hexa.productservice.application.port.secondary.ProductPersistencePort;
import dev.hexa.productservice.domain.model.Product;
import dev.hexa.productservice.domain.exeption.ProductNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DomainServiceAnnotation
public class Service implements ProductServicePort{
    private  final ProductPersistencePort productPersistencePort;

    @Override
    public Product ajouterProduit(Product product) {
        return productPersistencePort.save(product);
    }

    @Override
    public Product modifierProduit(Long id, Product product) {
        return productPersistencePort.findById(id).map(productUpdated->{
            productUpdated.setName(product.getName());
            productUpdated.setPrice(product.getPrice());
            productUpdated.setDescription(product.getDescription());
            productUpdated.setCategory(product.getCategory());
            return productPersistencePort.save(productUpdated);
        }).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product checherProduit(Long id) {
        return productPersistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void supprimerProduit(Long id) {
        productPersistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
        productPersistencePort.deleteById(id);

    }

}
