package com.scalar.productservice;

import com.scalar.productservice.model.Category;
import com.scalar.productservice.model.Product;
import com.scalar.productservice.repository.CategoryRepository;
import com.scalar.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ProductServiceFakeStoreServiceApplicationTests {

//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void productService()
    {
//        List<Category> category = categoryRepository.findAll();
//        System.out.println(category);
////        HashMap<Integer, Product> products = new HashMap<>();
////        products.replace();
////        ArrayList<Integer> re = new ArrayList<>();
////        re.forEach();
//        List<Integer> result = new ArrayList<>();



    }

}

//@SpringBootTest
//class ProductService13AprilApplicationTests {
//
//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private CategoryRepository catRepository;
//
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void testMyDB() {
//        List<Category> p = catRepository.findAll();
//        System.out.println(" Cat is: " + p.size() + " " + p.get(0));
//
//        List<Product> products = p.get(0).getProducts();
//        System.out.println("title: " + products.get(0).getTitle());
//    }
