package com.scalar.productservice.advise;

import com.scalar.productservice.dto.ErrorDto;
import com.scalar.productservice.exception.CategoryNotFoundException;
import com.scalar.productservice.exception.ProductNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.catalog.CatalogException;

@ControllerAdvice
public class ControllerAdvise extends ResponseEntityExceptionHandler {
//public class ControllerAdvise extends Exception {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ErrorDto> handelProductServiceException()
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Some error occurred in product service.");
        errorDto.setCode(400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
        //return new ResponseEntity(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    private ResponseEntity<ErrorDto> handelCategoryServiceException()
    {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Some error occurred in category service.");
        errorDto.setCode(400);
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }
}
