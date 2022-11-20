package com.example.dto;

import lombok.Data;
import lombok.ToString;

@ToString(of = {"name", "price"})
@Data
public class ProductDto {

    private long id;
    private String name;
    private double price;
}
