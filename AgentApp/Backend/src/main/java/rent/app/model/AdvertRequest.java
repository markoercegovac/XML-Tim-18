package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Table
@Entity
public class AdvertRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long advertId;

    @Column
    private String userEmail;

    @Column
    private Date dateStart;

    @Column
    Date dateEnd;



}
