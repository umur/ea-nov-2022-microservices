package edu.miu.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDto {
    private long id;
    private String name;
    private String color;
}
