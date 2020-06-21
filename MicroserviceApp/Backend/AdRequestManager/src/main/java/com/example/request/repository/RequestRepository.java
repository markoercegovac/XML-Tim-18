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

	@Query(value = "SELECT r.* FROM request r \n" +
			"INNER JOIN advert_copy_requests ar\n" +
			"ON r.request_id = ar.requests_request_id \n" +
			"WHERE ar.advert_copy_advert_copy_id = :id\n" +
			"AND r.end_reservation_date <= :startDate\n" +
			"AND r.start_reservation_date >= :endDate", nativeQuery = true)
	Optional<List<Request>> findAllByAdvertIdAndDatesBetween(
		@Param("id") Long advertId,
		@Param("startDate") Date startDate,
		@Param("endDate") Date endDate);
}
