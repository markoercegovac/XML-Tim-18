package com.example.request.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "car_reserved_date")
public class CarReservedDate implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "advert_copy_id", referencedColumnName = "advert_copy_id", nullable = false)
    private AdvertCopy advertCopy;
}
