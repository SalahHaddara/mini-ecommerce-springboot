package com.salahhaddara.miniecommercespringboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {

    private Long id;
    private String email;
}
