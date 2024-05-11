package com.scalar.productservice.service;

import com.scalar.productservice.dto.FakeStoreResponseDTO;
import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.model.Constants;
import com.scalar.productservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class FakeStoreService implements ProductService {

    private final RestTemplate restTemplate;

     public FakeStoreService(RestTemplate restTemplate) {
         this.restTemplate = restTemplate;
     }

//    @Override
//    public List<Product> getAllProducts(Integer pageNumber, Integer pageSize) {
//        return List.of();
//    }

    @Override
    public List<Product> getAllProducts(Integer pageNumber, Integer pageSize) {
        return List.of();
    }

    @Override
    public Product getProduct(Integer id) {
       ResponseEntity<FakeStoreResponseDTO> response =
               restTemplate.getForEntity(Constants.baseUrl + id, FakeStoreResponseDTO.class);
       FakeStoreResponseDTO fakeStoreResponseDTO = response.getBody();
       return fakeStoreResponseDTO.getProduct();
    }

    @Override
    public List<Product> getProducts() {
      FakeStoreResponseDTO[] products = restTemplate.getForObject(Constants.baseUrl, FakeStoreResponseDTO[].class);
       List<Product> productList = new ArrayList<>();
       for (FakeStoreResponseDTO fakeStoreResponseDTO : products) {
           productList.add(fakeStoreResponseDTO.getProduct());
       }
       return productList;
    }

    @Override
    public Product addProduct(String title, String price, String description, String image, String category) throws CategoryNotFoundException {
        FakeStoreResponseDTO requestBody = new FakeStoreResponseDTO();
        requestBody.setTitle(title);
        requestBody.setImage(image);
        requestBody.setDescription(description);
        requestBody.setPrice(String.valueOf(price));
        FakeStoreResponseDTO response =  restTemplate.postForObject(Constants.baseUrl, requestBody, FakeStoreResponseDTO.class);
        return response.getProduct();
    }

    @Override
    public Product deleteProduct(Integer id) {
        restTemplate.delete(Constants.baseUrl + id, FakeStoreResponseDTO.class);
        return null;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        return null;
    }
}
