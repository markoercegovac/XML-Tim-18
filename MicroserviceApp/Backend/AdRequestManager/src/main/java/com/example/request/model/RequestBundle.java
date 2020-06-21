package com.example.request.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
@Table(name = "request_bundle")
public class RequestBundle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="request_bundle_id")
    private Long requestBundleId;

    @Email
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @Email
    @Column(name = "requesting_user_email", nullable = false)
    private String requestingUserEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "advert_state", nullable = false)
    private AdvertStateEnum advertState;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "creation_date_and_time", nullable = false)
    private Date creationDateAndTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "approved_date_and_time", nullable = true)
    private Date approvedDateAndTime;

    @Column(name = "price_with_discount", nullable = false)
    private double priceWithDiscount;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Request> requests;
}
