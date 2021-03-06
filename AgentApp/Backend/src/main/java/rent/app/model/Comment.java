package rent.app.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client client;



    @Column
    private String author;

    @Column
    private boolean isApproved; //verovatno enum{NOV, ODOBREN, ODBIJEN}

}
