package com.example.request.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.request.model.Request;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	@Query(value = "SELECT r FROM Request r WHERE "+
		" r.advertCopy.advertCopyId = :id and " +
		" r.startReservationDate BETWEEN :startDate AND :endDate AND"+
		" r.endReservationDate BETWEEN :startDate AND :endDate")
	Optional<List<Request>> findAllByAdvertIdAndDatesBetween(
		@Param("id") Long advertId,
		@Param("startDate") Date startDate,
		@Param("endDate") Date endDate);
}
