package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Data
@Entity
@Table(name="Price")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private float pricePerDay;

    @Column
    private float insurancePrice;

    @Column
    private float distanceOverflowPrice;


    @Column
    private float discount;

    @Column
    private boolean isRemoved;



}
