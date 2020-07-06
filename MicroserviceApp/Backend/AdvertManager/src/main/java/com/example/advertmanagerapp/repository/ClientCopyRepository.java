package com.example.advertmanagerapp.repository;

import com.example.advertmanagerapp.model.ClientCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCopyRepository extends JpaRepository<ClientCopy,Long> {

    ClientCopy findByEmail(String email);
    ClientCopy findByAdvertsId(Long id);

}
