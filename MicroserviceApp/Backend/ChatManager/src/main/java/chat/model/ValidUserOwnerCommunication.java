package chat.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table
public class ValidUserOwnerCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long validCommunicationId;

    @Email(message = "must ba a valid email")
    @Length(min = 5, max = 51)
    @Column(nullable = false)
    private String userEmail;

    @Email(message = "must ba a valid email")
    @Length(min = 5, max = 51)
    @Column(nullable = false)
    private String ownerEmail;

    @Column(nullable = false)
    private boolean isDeleted;
}
