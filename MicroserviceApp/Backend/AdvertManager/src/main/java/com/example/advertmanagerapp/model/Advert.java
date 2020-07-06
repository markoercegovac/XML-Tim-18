package com.example.advertmanagerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ConcreteCar concreteCar;

    @Lob
    @Column(name="profilePicture")
    private String profilePicture;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.PERSIST)
    private List<Picture> pictureSet;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private ClientCopy client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="startOfAdvert")
    private Date startOfAdvert;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="endOfAdvert")
    private Date endOfAdvert;

    @Column(name="description")
    private String description;

    @Column(name="isActive")
    private boolean isActive;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ClientCopy currentDriver;

    @OneToMany
    private List<Capture> captures;


}
