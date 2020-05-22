package com.user.manager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    private Collection<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;
}
