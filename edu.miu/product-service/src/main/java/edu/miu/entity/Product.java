package edu.miu.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "users")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;


}
