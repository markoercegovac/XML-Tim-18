package com.example.request.repository;

import com.example.request.model.Request;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}
