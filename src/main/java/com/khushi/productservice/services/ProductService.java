package com.khushi.productservice.services;

import com.khushi.productservice.models.Product;

public interface ProductService {
    Product getProductById(Long id);
}
