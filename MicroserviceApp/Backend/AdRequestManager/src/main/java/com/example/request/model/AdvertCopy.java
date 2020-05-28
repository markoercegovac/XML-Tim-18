package com.example.request.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "advert_copy")
public class AdvertCopy {

    @Id
    @Column(name = "advert_copy_id", nullable = false)
    private Long advertCopyId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "advert_end_date", nullable = false)
    private Date advertEndDate;

    @Email
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @OneToMany(mappedBy = "advertCopy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Request> request;

    @OneToMany(mappedBy = "advertCopy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarReservedDate> carReservedDate;
}
