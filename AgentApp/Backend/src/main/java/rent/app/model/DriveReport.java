package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table
public class DriveReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="CarTraveledDistance")
    private float traveledDistance;

    @Column(name="CarDescribe")
    private String describe;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CarDateOfReport")
    private Date dateOfReport;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Car carReport;
}
