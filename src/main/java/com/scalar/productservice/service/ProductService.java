package com.scalar.productservice.service;

import com.scalar.productservice.model.Product;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ProductService {
    Product getProduct(Integer id);
    List<Product> getProducts();
    Product addProduct(String title, Double price,
                       String description, String image);
    HttpStatus deleteProduct(Integer id);
    Product updateProduct(Integer id, Product product);
}
