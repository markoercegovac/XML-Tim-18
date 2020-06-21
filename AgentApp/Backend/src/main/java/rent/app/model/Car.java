package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrand_id", referencedColumnName = "id")
    private CarBrand carBrand;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carClass_id", referencedColumnName = "id")
    private CarClass carClass;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carFuelType_id", referencedColumnName = "id")
    private CarFuelType carFuelType;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carModel_id", referencedColumnName = "id")
    private CarModel carModel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTransmissionType_id", referencedColumnName = "id")
    private CarTransmissionType carTransmissionType;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mileage_id", referencedColumnName = "id")
    private Mileage mileage;

    @Column
    private Long travelDistanceConstraint;

    @Column
    private boolean isInsurance;

    @Column
    private int childrenSitNumber;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client client;

    @OneToMany(mappedBy = "car",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Advert> adverts;

    @OneToMany(mappedBy = "carReport",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DriveReport> reports;

}
