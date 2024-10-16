package com.example.productservicedemo.inheitancerespresentation.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_ta")
public class TA extends User {
    private int numberOfSessions;
    private double averageRating;
}
