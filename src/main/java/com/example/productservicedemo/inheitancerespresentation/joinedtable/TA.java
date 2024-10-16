package com.example.productservicedemo.inheitancerespresentation.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
public class TA extends User {
    private int numberOfSessions;
    private double averageRating;
}
