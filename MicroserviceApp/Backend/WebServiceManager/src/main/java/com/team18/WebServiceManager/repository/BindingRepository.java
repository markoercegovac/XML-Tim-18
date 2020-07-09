package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Binding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BindingRepository extends JpaRepository<Binding, Long> {
}
