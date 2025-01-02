package com.khushi.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    String description;

    @OneToMany(mappedBy = "category")
    List<Product> productList;

//    @OneToMany(fetch = FetchType.EAGER)
//    List<Product> productList;
}
