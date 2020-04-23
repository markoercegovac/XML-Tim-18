package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="DriveReport")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float traveledDistance;

    @Column(name="Describe")
    private String describe;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateOfReport")
    private Date dateOfReport;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Car car;
}
