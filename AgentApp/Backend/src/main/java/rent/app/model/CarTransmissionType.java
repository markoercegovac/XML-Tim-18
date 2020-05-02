package rent.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class CarTransmissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Min(2)
    @Max(32)
    private String transmissionType;

    @Column
    private boolean isRemoved;

}

