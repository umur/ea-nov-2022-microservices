package edu.miu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credential {

    private String username;
    private String password;

//    @Override
//    public String toString() {
//        return "{" +
//                "\"username\": \"" + username + '\"' +
//                ", \"password\": \"" + password + '\"' +
//                '}';
//    }
}
