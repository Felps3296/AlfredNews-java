package com.felps.newssystem.service;

import com.felps.newssystem.dto.PreferenceRequestDTO;
import com.felps.newssystem.dto.PreferenceResponseDTO;
import com.felps.newssystem.model.Preference;
import com.felps.newssystem.model.User;
import com.felps.newssystem.repository.PreferenceRepository;
import com.felps.newssystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final UserRepository userRepository;

    public PreferenceResponseDTO addPreference(PreferenceRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Preference preference = new Preference();
        preference.setCategory(dto.getCategory());
        preference.setUser(user);

        Preference saved = preferenceRepository.save(preference);

        return new PreferenceResponseDTO(saved.getId(), saved.getCategory(), user.getId());
    }

    public List<PreferenceResponseDTO> getPreferencesByUser(Long userId) {
        return preferenceRepository.findByUserId(userId)
                .stream()
                .map(p -> new PreferenceResponseDTO(p.getId(), p.getCategory(), userId))
                .toList();
    }
}