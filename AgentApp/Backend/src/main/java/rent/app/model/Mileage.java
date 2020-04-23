package rent.app.model;

import lombok.Data;
import rent.app.model.enums.TraveledUnit;

import javax.persistence.*;

@Data
@Entity
@Table(name="Mileage")
public class Mileage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long traveledDistance;

    @Enumerated(EnumType.STRING)
    @Column
    private TraveledUnit traveledUnit;

    @Column
    private boolean isRemoved;
}
