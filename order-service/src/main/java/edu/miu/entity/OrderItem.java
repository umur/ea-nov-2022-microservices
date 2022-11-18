package edu.miu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;

    private int quantity;

    private double price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Order order;

}
