package com.example.productservicedemo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private Double price;
    private Category category;
    private String description;
    private String image;
}
