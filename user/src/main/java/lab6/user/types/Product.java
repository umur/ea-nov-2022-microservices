package lab6.user.types;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int userId;
    private double price;
}
