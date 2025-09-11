package com.salahhaddara.miniecommercespringboot.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotEmpty
    @Valid
    private List<OrderItemRequest> items;
}

