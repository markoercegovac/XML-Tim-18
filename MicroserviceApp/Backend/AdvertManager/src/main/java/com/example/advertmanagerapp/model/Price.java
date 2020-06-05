package com.example.advertmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private String priceName;

    @Column(nullable = false)
    private float pricePerDay;

    @Column(nullable = true)
    private Float insurancePrice;

    @Column(nullable = true)
    private Float distanceOverflowPrice;

    //@Max(1)
    //@Min(0)
    @Column(nullable = true)
    private Float discount;

    @Column(nullable = false)
    private boolean isRemoved;

//    @OneToMany(mappedBy = "price",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<Advert> advertSet;

}
