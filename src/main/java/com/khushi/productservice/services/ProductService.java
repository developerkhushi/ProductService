package com.khushi.productservice.services;

import com.khushi.productservice.exceptions.ProductNotFoundException;
import com.khushi.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    Product createProduct(Product product);
}
