package com.felps.newssystem.controller;

import com.felps.newssystem.dto.LoginRequestDTO;
import com.felps.newssystem.dto.UserRequestDTO;
import com.felps.newssystem.dto.UserResponseDTO;
import com.felps.newssystem.repository.UserRepository;
import com.felps.newssystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        UserResponseDTO response = userService.login(dto);
        return ResponseEntity.ok(response);
    }
}