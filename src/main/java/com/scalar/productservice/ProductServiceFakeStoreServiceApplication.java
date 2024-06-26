package com.scalar.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SpringBootApplication
@EnableScheduling
public class ProductServiceFakeStoreServiceApplication {

    public static void main(String[] args) {
            SpringApplication.run(ProductServiceFakeStoreServiceApplication.class, args);
    }
}

