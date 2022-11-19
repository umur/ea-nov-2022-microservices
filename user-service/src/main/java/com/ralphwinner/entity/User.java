package com.ralphwinner.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String fullName;
    public LocalDate dateOfBirth;
    public String email;
    public String password;

}
