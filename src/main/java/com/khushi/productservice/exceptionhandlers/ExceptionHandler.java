package com.khushi.productservice.exceptionhandlers;

import com.khushi.productservice.dtos.ProductNotFoundExceptionDto;
import com.khushi.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleInstanceNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(exception.getId());
        productNotFoundExceptionDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleNullException(ProductNotFoundException exception) {
        ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
        productNotFoundExceptionDto.setErrorCode(exception.getId());
        productNotFoundExceptionDto.setMessage(exception.getMessage());
        return new ResponseEntity<>(productNotFoundExceptionDto, HttpStatus.NOT_FOUND);
    }
}
