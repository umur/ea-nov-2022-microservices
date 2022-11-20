package miu.edu.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private  int Id;
    private String name;
    private int age;
}
