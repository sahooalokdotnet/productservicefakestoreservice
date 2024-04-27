package com.scalar.productservice.service;

import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.exception.ProductNotFoundException;
import com.scalar.productservice.model.Category;
import com.scalar.productservice.model.Product;

import com.scalar.productservice.repository.CategoryRepository;
import com.scalar.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service("selfProductService")
    public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(String title, String price, String description, String image,String categoryName) throws CategoryNotFoundException {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if(category == null)
        {
            throw  new CategoryNotFoundException("Category not exists");
        }
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(image);
        product.setPrice(price);
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new Product();
    }

    @Override
    public Product updateProduct(Integer id, Product product) throws ProductNotFoundException, CategoryNotFoundException {
        Product oldProduct = productRepository.findProductById(id);
        if(oldProduct == null)
        {
            throw  new ProductNotFoundException("Product with id is not exist.");
        }
        Category oldCategory =  categoryRepository.findCategoryByName(oldProduct.getCategory().getName());
        if(oldCategory == null)
        {
            throw new CategoryNotFoundException("Category is not exists.");
        }
        return productRepository.save(product);
    }
}
