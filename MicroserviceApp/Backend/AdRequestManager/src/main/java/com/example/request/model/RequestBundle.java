package com.example.request.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "request_bundle")
public class RequestBundle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="request_bundle_id")
    private Long requestBundleId;

    @Email
    @Length(min = 5, max = 51)
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;

    @Email
    @Length(min = 5, max = 51)
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
    @Min(value = 0)
    private double priceWithDiscount;

    @OneToMany(mappedBy = "requestBundle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Request> requests;
}
