package com.example.advert_search.repository;

import com.example.advert_search.model.AdvertCopy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SearchRepository extends JpaRepository<AdvertCopy, Long> {

   // List<AdvertCopy> findAllByStartOfAdvertGreaterThanAndStartOfAdvertGreaterThanOrEndOfAdvertLessThanAndEndOfAdvertLessThan(Date startDate, Date endDate, Date startDate2, Date endDate2);
    List<AdvertCopy> findAll();
    AdvertCopy findByAdvertCopyId(Long id);
}
