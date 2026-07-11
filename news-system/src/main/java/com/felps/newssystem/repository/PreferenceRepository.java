package com.felps.newssystem.repository;

import com.felps.newssystem.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PreferenceRepository extends JpaRepository <Preference, Long>{
    List<Preference>findByUserId(Long userid);
}
