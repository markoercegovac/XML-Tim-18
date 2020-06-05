package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.Capture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaptureRepository extends JpaRepository<Capture,Long> {
}
