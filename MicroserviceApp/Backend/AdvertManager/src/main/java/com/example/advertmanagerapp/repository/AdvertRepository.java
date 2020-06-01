package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert,Long> {
}
