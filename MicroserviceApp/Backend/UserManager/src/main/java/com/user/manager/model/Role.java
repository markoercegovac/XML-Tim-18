package com.user.manager.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany(fetch=FetchType.EAGER)
    private Collection<Permission> permissions;
}
