package com.example.request.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "request")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="request_id")
    private Long requestId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "start_reservation_date", nullable = false)
    private Date startReservationDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "end_reservation_date", nullable = false)
    private Date endReservationDate;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "request_bundle_id", nullable = false)
    private RequestBundle requestBundle;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "advert_copy_id", nullable = false)
    private AdvertCopy advertCopy;
}
