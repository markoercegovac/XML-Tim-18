package rent.app.model;



import lombok.Data;
import rent.app.model.enums.RequestStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class RegistrationRequest {


    @Id
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private RequestStatus status;

}
