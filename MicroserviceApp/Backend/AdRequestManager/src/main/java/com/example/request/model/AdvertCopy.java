package com.example.request.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Request> requests;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CarReservedDate> carReservedDate;
}
