package chat.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private Long messageId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="valid_communication_id", nullable = false)
    private ValidUserOwnerCommunication validUserOwnerCommunication;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DirectionEnum direction;

    @Length(min = 3, max = 124)
    @Column(name="header", nullable = false)
    private String header;

    @Column(name="content", nullable = false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date", nullable = false)
    private Date creationDate;

    @Column(name="is_seen", nullable = false)
    private boolean isSeen;

}
