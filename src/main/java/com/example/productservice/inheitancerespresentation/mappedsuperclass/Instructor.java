package com.example.productservice.inheitancerespresentation.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msu_instructor")
public class Instructor extends User{
    private String specialization;
}
