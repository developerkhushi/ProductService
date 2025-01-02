package com.khushi.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mps_mentor")
public class Mentor extends User{
    String company;
    int avgRating;
}
