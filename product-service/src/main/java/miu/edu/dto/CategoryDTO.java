package miu.edu.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
