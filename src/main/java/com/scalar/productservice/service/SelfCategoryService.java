package com.scalar.productservice.service;

import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.model.Category;
import com.scalar.productservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfCategoryService implements  CategoryService {
    private final CategoryRepository categoryRepository;
    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Integer id) throws CategoryNotFoundException{
        Category category1 = categoryRepository.findCategoryById(id);
        if(category1 == null)
        {
            throw new CategoryNotFoundException("Category not found.");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteCategoryById(id);
    }
}
