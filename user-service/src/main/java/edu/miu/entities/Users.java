package edu.miu.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    private long id;
    private String name;
    private int age;
}
