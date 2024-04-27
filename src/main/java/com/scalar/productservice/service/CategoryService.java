package com.scalar.productservice.service;

import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer id);
    Category getCategoryByName(String name);
    Category saveCategory(Category category);
    Category updateCategory(Category category, Integer id) throws CategoryNotFoundException;
    void deleteCategory(Integer id);
}
