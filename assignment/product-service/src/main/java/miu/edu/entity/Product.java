package miu.edu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Product {
    @Id
    private int id;

    private String name;
    private String color;
}
