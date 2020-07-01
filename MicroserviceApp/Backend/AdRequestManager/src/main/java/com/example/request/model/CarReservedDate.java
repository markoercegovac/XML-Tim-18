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
@Table(name = "car_reserved_date")
public class CarReservedDate {

    /**
     * Whe owner manualy reserve car
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="car_reserved_date_id")
    private Long carReservedDateId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

}
