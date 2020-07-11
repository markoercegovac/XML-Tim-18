package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name="CarFuelType")
public class CarFuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String fuelType;

    @Column
    private boolean isRemoved;

}
