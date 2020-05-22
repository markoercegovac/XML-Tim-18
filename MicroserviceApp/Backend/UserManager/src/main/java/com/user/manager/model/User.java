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
    private String username;

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
    private boolean isRemoved;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
}
