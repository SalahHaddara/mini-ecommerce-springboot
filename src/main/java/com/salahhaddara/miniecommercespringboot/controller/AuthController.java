package com.salahhaddara.miniecommercespringboot.controller;

import com.salahhaddara.miniecommercespringboot.dto.LoginRequest;
import com.salahhaddara.miniecommercespringboot.dto.LoginResponse;
import com.salahhaddara.miniecommercespringboot.dto.RegisterRequest;
import com.salahhaddara.miniecommercespringboot.dto.RegisterResponse;
import com.salahhaddara.miniecommercespringboot.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request) {
        RegisterResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
