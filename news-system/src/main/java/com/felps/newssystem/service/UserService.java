package com.felps.newssystem.service;

import com.felps.newssystem.dto.LoginRequestDTO;
import com.felps.newssystem.dto.UserRequestDTO;
import com.felps.newssystem.dto.UserResponseDTO;
import com.felps.newssystem.model.User;
import com.felps.newssystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // sem criptografia por enquanto

        User saved = userRepository.save(user);
        return new UserResponseDTO(saved.getId(), saved.getName(), saved.getEmail());
    }

    public UserResponseDTO login(LoginRequestDTO tdo){
        User user = userRepository.findByEmail(dto.Email())
                .orElsepublic UserResponseDTO login(LoginRequestDTO dto) {
            User user = userRepository.findByEmail(dto.getEmail())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            if (!user.getPassword().equals(dto.getPassword())) {
                throw new RuntimeException("Senha incorreta");
            }

            return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
        }
    }
}