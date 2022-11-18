package miu.edu.service;

import miu.edu.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> findAll();
    Optional<CategoryDTO> findOne(Long id);
    CategoryDTO save(CategoryDTO product);
    void delete(Long id);
}
