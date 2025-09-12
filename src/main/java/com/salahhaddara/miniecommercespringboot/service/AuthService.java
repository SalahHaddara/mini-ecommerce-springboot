package com.salahhaddara.miniecommercespringboot.service;

import com.salahhaddara.miniecommercespringboot.dto.LoginRequest;
import com.salahhaddara.miniecommercespringboot.dto.LoginResponse;
import com.salahhaddara.miniecommercespringboot.dto.RegisterRequest;
import com.salahhaddara.miniecommercespringboot.dto.RegisterResponse;
import com.salahhaddara.miniecommercespringboot.entity.User;
import com.salahhaddara.miniecommercespringboot.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request) {
        User user = userService.registerUser(request.getEmail(), request.getPassword());

        return RegisterResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
