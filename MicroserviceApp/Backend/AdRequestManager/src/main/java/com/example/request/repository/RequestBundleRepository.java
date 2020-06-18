package com.example.request.repository;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RequestBundleRepository extends JpaRepository<RequestBundle, Long> {

    Optional<List<RequestBundle>> findAllByRequestingUserEmail(String clientEmail);
    Optional<List<RequestBundle>> findAllByRequestingUserEmailAndAdvertState(String clientEmail, AdvertStateEnum state);

    Optional<List<RequestBundle>> findAllByOwnerEmail(String ownerEmail);
    Optional<List<RequestBundle>> findAllByOwnerEmailAndAdvertState(String ownerEmail, AdvertStateEnum state);

    @Query(value = "select b from RequestBundle b where b.ownerEmail = ?1 and b.creationDateAndTime <= ?2",
        nativeQuery = false)
    Optional<List<RequestBundle>> findAllByOwnerEmailAndCreationDateAndTimeBefore(String owner, Date beforeDate);

}
