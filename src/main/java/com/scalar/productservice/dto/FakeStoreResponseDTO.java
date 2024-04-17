package com.scalar.productservice.dto;

import com.scalar.productservice.model.Category;
import com.scalar.productservice.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private Integer id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public Product getProduct()
    {
        Product product = new Product();
        product.setId(id);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setTitle(title);

        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);

        return product;
    }
}
