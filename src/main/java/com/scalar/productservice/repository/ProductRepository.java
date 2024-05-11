package com.scalar.productservice.repository;

import com.scalar.productservice.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
 Product save(Product product);
 List<Product> findAll();
 Product findProductById(Integer id);
 void deleteById(Integer id);
}
