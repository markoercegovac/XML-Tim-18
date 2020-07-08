package rent.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class ReservationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ownerEmail;

    @Column
    private String customerEmail;

    @Column
    private Long idAdvert;

    @Column
    private boolean isAccepted;
}
