package com.example.productservicedemo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private  Long productId;
    private String message;
    private String details;
}
