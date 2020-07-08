package rent.app.model.security;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;




}
