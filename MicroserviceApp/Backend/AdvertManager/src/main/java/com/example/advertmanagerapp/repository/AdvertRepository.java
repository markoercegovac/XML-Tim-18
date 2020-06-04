package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {

    Optional<Advert> findByIdAndIsActiveTrue(Long aLong);

}
