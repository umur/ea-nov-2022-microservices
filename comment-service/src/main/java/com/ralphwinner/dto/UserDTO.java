package com.ralphwinner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    public Long Id;
    public String fullName;
    public LocalDate dateOfBirth;
    public String email;
    public String password;
}
