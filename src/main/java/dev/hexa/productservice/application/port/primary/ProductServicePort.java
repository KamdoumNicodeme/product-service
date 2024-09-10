package dev.hexa.productservice.application.port.primary;

import dev.hexa.productservice.domain.model.Product;

public interface ProductServicePort {
    Product ajouterProduit(Product product);
    Product modifierProduit(Long id,Product product);
    Product checherProduit(Long id);
    void supprimerProduit(Long id);
}
