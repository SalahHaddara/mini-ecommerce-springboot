package com.salahhaddara.miniecommercespringboot.dto;

import com.salahhaddara.miniecommercespringboot.entity.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderItemResponse {

    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;

    public static OrderItemResponse fromEntity(OrderItem orderItem) {
        return OrderItemResponse.builder()
                .id(orderItem.getId())
                .productId(orderItem.getProduct().getId())
                .productName(orderItem.getProduct().getName())
                .quantity(orderItem.getQuantity())
                .unitPrice(orderItem.getUnitPrice())
                .subtotal(orderItem.getSubtotal())
                .build();
    }
}

