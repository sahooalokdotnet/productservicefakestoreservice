package com.scalar.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequestDTO {
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;
}
