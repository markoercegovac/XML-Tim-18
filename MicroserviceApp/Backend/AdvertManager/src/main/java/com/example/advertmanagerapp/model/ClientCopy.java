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

    /*
    *IMA PREVISE OBELEZJA
    */
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String streetNumber;

    @Column
    private String password;

    @Column
    private boolean isBanned;

    @Column
    private boolean isRemoved;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

//    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<OwnersCar> ownersCars;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Advert> adverts;

}
