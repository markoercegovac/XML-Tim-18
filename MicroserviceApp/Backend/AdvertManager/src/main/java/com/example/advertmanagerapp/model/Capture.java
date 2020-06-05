package com.example.advertmanagerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Capture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date takeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date leaveDate;

}
