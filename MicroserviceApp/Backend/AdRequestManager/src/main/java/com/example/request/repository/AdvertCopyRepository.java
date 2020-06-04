package com.example.request.repository;

import com.example.request.model.AdvertCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertCopyRepository extends JpaRepository<AdvertCopy, Long> {

}
