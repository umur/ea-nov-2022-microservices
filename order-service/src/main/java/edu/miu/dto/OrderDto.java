package edu.miu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int id;

    private String comment;

    private int userId;

    private LocalDateTime dateTime;

    private List<OrderItemDto> orderItems;
}
