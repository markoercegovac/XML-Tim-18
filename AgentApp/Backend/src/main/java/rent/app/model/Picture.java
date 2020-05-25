package rent.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Advert advert;

    @Column
    private boolean isDeleted;
}
