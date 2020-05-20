package com.example.request.repository;

import com.example.request.model.RequestBundle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestBundleRepository extends JpaRepository<RequestBundle, Long> {
}
