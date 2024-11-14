package com.khushi.productservice.services;

import com.khushi.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}
