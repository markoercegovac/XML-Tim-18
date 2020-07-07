package com.comment.manager.manager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int grade;

    @Column
    private Long advertId;
}
