package com.user.manager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Table
@Entity
public class User {

    @Id
    private String email;

    @Column(nullable=false)
    private String username; //orCompany name

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String streetNumber;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean isBanned;

    @Column
    private boolean isForbiddenAdvert;

    @Column
    private boolean isRemoved;

    @Column
    private boolean adminApproved; //true znaci da je odobren, false ja da treba da se odobri

    @Column(nullable = true)
    private String companyRegistrationNumber; //if not null we have a company(AGENT)

    @Column(nullable = true)
    private String agentUrl;

    @ManyToMany(fetch=FetchType.EAGER)
    private Collection<Role> roles;
}
