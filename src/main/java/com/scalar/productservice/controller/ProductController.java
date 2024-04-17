package com.scalar.productservice.controller;

import com.scalar.productservice.dto.ProductRequestDTO;
import com.scalar.productservice.dto.ProductResponseDTO;
import com.scalar.productservice.model.Product;
import com.scalar.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<ProductResponseDTO> getProducts()
    {
        List<Product> products = productService.getProducts();
        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

        for (Product product : products) {
             productResponseDTOs.add(getProductResponseFromProduct(product));
        }
        return productResponseDTOs;
    }
    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable Integer id)
    {
        Product product = this.productService.getProduct(id);
        return getProductResponseFromProduct(product);
    }


    @PostMapping("/products")
    public ProductResponseDTO postProduct(@RequestBody ProductRequestDTO dto)
    {
        Product product = productService.addProduct(dto.getTitle(),dto.getPrice(),dto.getDescription(), dto.getImage());
        return getProductResponseFromProduct(product);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO putProductById(@PathVariable Integer id, @RequestBody ProductRequestDTO dto)
    {
        Product product =new Product();
        return getProductResponseFromProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable Integer id)
    {
        HttpStatus product = productService.deleteProduct(id);
        if(product == HttpStatus.OK)
        {
            return "Product deleted successfully";
        }
        return "Product could not be deleted";
    }






    private ProductResponseDTO  getProductResponseFromProduct(Product product)
    {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setImageUrl(product.getImageUrl());
        productResponseDTO.setTitle(product.getTitle());
        return productResponseDTO;
    }
}
