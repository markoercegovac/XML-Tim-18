package com.example.advert_search.repository;

import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface CarReservedDateRepository extends JpaRepository<CarReservedDate, Long> {
    List<CarReservedDate> findAllByStartOfAdvertGreaterThanAndStartOfAdvertGreaterThanOrEndOfAdvertLessThanAndEndOfAdvertLessThan( Date startDate, Date endDate, Date startDate2, Date endDate2);


}
