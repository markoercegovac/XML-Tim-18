package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,Long> {
	Picture findByPath(String path);
}
