package com.example.productservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
