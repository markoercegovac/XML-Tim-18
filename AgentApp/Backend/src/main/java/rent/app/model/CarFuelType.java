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
    @Min(2)
    @Max(32)
    private String fuelType;

    @Column
    private boolean isRemoved;

}
