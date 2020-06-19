package com.comment.manager.manager.model;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
@Data
public class AdvertCopy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

}
