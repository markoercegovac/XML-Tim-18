package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date takeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date leaveDate;
}
