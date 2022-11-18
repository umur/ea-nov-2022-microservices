package miu.edu.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String zipcode;
}