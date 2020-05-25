package rent.app.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.sql.DataSourceDefinitions;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Min(2)
    @Max(32)
    private String name;

    @Column
    private boolean isRemoved;

}
