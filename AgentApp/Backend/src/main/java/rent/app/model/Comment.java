package rent.app.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Advert advert;

    @Column
    private boolean isApproved; //verovatno enum{NOV, ODOBREN, ODBIJEN}

}
