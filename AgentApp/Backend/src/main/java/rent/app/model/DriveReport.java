package rent.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class DriveReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private float traveledDistance;

    @Column
    private String describe;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateOfReport;

 //   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
 //   private Car carReport;
}
