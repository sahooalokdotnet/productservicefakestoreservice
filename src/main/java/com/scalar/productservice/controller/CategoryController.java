package com.scalar.productservice.controller;

import com.scalar.productservice.dto.CategoryRequestDTO;
import com.scalar.productservice.dto.CategoryResponseDTO;
import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.exception.ProductNotFoundException;
import com.scalar.productservice.model.Category;
import com.scalar.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public List<CategoryResponseDTO> getCategory() {

        List<Category> category =  this.categoryService.getAllCategories();
        List<CategoryResponseDTO> categoryResponseDTOS = new ArrayList<>();
        for (Category categoryItem : category) {
            categoryResponseDTOS.add(getCategoryResponseFromProduct(categoryItem));
        }
        return categoryResponseDTOS;
    }
    @GetMapping("/category/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable("id") Integer id) throws CategoryNotFoundException{
        Category category = this.categoryService.getCategoryById(id);
        if(category == null)
        {
            throw new CategoryNotFoundException("Some error occurred");
        }
        return getCategoryResponseFromProduct(category);
    }
    @GetMapping("/category/byname/{name}")
    public CategoryResponseDTO getCategoryByName(@PathVariable("name") String name) throws CategoryNotFoundException{
        Category category = this.categoryService.getCategoryByName(name);
        if(category == null)
        {
            throw new CategoryNotFoundException("Some error occurred");
        }
        return getCategoryResponseFromProduct(category);
    }
    @PostMapping("category")
    public CategoryResponseDTO addCategory(@RequestBody CategoryRequestDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        Category cate =  this.categoryService.saveCategory(category);
        return getCategoryResponseFromProduct(cate);
    }

    @PutMapping("category/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryRequestDTO categoryDTO) throws CategoryNotFoundException {
        Category category = new Category();
        category.setId(id);
        category.setName(categoryDTO.getName());
        Category cate = this.categoryService.updateCategory(category, id);
        return getCategoryResponseFromProduct(cate);
    }
    @DeleteMapping("category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id)
    {
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok().body("Category deleted successfully");
    }

    private CategoryResponseDTO getCategoryResponseFromProduct(Category category)
    {

        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        categoryResponseDTO.setId(category.getId());
        categoryResponseDTO.setName(category.getName());
        return categoryResponseDTO;
    }
}
