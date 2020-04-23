package rent.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name="Grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Max(5)
    @Min(0)
    @Column
    private int grade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advert_id", referencedColumnName = "id")
    private Advert advert;

}
