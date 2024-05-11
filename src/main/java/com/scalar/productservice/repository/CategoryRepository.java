package com.scalar.productservice.repository;

import com.scalar.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoryByName(String name);
    List<Category> findAll();
//    Category update(Category category);
    Category findCategoryById(Integer id);
    Category save(Category category);
    void deleteCategoryById(Integer id);
}
