package com.scalar.productservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageUrl;

}
