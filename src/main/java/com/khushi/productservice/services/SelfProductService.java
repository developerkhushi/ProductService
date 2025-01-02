package com.khushi.productservice.services;

import com.khushi.productservice.exceptions.ProductNotFoundException;
import com.khushi.productservice.models.Category;
import com.khushi.productservice.models.Product;
import com.khushi.productservice.projections.ProductTitleAndDescription;
import com.khushi.productservice.repos.CategoryRepo;
import com.khushi.productservice.repos.ProductRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    ProductRepo productRepo;
    private final CategoryRepo categoryRepo; // Ideally category service

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
//        ProductTitleAndDescription productTileAndDescription = productRepo.getProductTitleAndDesc(id);
//        System.out.println("Projection: " + productTileAndDescription.getTitle() + " " + productTileAndDescription.getDescription());
        return productRepo.findById(id).get();

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category == null) {
            throw new IllegalArgumentException("Product must have a valid category.");
        }

        if (category.getId() == null) {
            // If the category does not have an ID, save it as a new category
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        } else {
            // Validate the existing category
            Optional<Category> existingCategory = categoryRepo.findById(category.getId());
            if (existingCategory.isPresent()) {
                product.setCategory(existingCategory.get());
            } else {
                throw new IllegalArgumentException("Invalid category ID: " + category.getId());
            }
        }

        // Save and return the product
        return productRepo.save(product);
    }

}
