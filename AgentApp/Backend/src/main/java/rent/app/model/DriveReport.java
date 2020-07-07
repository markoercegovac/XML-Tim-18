package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table
public class DriveReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CarTraveledDistance")
    private float traveledDistance;

    @Column(name="CarDescribe")
    private String describe;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CarDateOfReport")
    private Date dateOfReport;

}
