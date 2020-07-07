package com.example.request.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="request_id")
    private Long requestId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "start_reservation_date", nullable = false)
    private Date startReservationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "end_reservation_date", nullable = false)
    private Date endReservationDate;

}
