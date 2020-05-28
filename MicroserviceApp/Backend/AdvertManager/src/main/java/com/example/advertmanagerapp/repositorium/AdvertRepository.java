package com.example.advertmanagerapp.repositorium;

import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<CarModel, Long> {
}
