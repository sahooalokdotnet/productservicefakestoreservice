package com.scalar.productservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private String price;
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Category category;
}
