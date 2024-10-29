package com.example.productservice.inheitancerespresentation.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msu_mentor")
public class Mentor extends User {
    private double averageRating;

}
