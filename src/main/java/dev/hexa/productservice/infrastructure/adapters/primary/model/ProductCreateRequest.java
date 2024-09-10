package dev.hexa.productservice.infrastructure.adapters.primary.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

        private String name;
        private Double price;
        private String description;
        private String category;

}
