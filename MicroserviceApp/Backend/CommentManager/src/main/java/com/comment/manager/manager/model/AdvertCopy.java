package com.comment.manager.manager.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
@Data
@RequiredArgsConstructor
public class AdvertCopy {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ownerEmail;

    @Column
    private Date startDate;

    @Column
    private Date endDate;


}
