package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

//    @OneToMany (fetch = FetchType.EAGER, mappedBy = "category", cascade = CascadeType.REMOVE)
//    private List<Product> products; //LAZY FETCH by default, for collections, if we dont explicitly give fetchtype
    private String title;
}
