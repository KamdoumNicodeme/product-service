package dev.hexa.productservice.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String category;

}
