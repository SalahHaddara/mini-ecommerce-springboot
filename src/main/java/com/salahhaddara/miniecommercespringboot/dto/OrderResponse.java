package com.salahhaddara.miniecommercespringboot.dto;

import com.salahhaddara.miniecommercespringboot.entity.Order;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private String userEmail;
    private List<OrderItemResponse> items;
    private String status;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .userEmail(order.getUser().getEmail())
                .items(order.getItems().stream()
                        .map(OrderItemResponse::fromEntity)
                        .toList())
                .status(order.getStatus().name())
                .total(order.getTotal())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }
}
