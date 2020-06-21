package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String sender;

    @Column
    private String recipient;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date date;

}
