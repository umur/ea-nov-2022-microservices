package miu.edu.service;

import miu.edu.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressDTO> findAll();
    Optional<AddressDTO> findOne(Long id);
    AddressDTO save(AddressDTO product);
    void delete(Long id);
}
