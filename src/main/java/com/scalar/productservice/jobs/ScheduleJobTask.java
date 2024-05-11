package com.scalar.productservice.jobs;

import com.scalar.productservice.model.Product;
import com.scalar.productservice.repository.ProductRepository;
import com.scalar.productservice.service.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class ScheduleJobTask {
    private ProductRepository productRepository;
    public ScheduleJobTask(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    //sec, min, hour, dayOfMonth, Month, WeekDay
    @Scheduled(cron = "0 * * * * * ")
    //* means anything
    public void executeJob()
    {
       Optional<Product> product =  productRepository.findById(1);
       if(product.isPresent())
       {
           System.out.println("Product Fetch from database and ID:" + product.get().getId());
       }
    }
}
