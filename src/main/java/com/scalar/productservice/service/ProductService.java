package com.scalar.productservice.service;

import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.exception.ProductNotFoundException;
import com.scalar.productservice.model.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Integer id);
    List<Product> getProducts();
    Product addProduct(String title, String price,
                       String description, String image, String category) throws CategoryNotFoundException;
    Product deleteProduct(Integer id);
    Product updateProduct(Integer id, Product product) throws ProductNotFoundException, CategoryNotFoundException;
}
