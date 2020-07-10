package com.example.advertmanagerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.advertmanagerapp.model.enums.Role;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ClientCopy  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private boolean isBanned;

    @Column
    private boolean isRemoved;

    @Column
    private boolean isCreationEnabled;

    @Column
    private boolean isForbiddenAdvert;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Advert> adverts;

    @OneToMany
    private List<ConcreteCar> cars;

    @OneToMany
    private List<Price> priceList;

}
