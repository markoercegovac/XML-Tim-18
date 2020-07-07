package rent.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String path;

    @Column
    private boolean isDeleted;
}
