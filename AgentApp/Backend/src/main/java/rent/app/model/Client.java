package rent.app.model;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table
public class Client {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String pass;
}
