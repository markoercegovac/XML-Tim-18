package com.example.request.repository;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestBundleRepository extends JpaRepository<RequestBundle, Long> {

    Optional<List<RequestBundle>> findAllByRequestingUserEmail(String clientEmail);
    Optional<List<RequestBundle>> findAllByRequestingUserEmailAndAdvertState(String clientEmail, AdvertStateEnum state);

}
