package rent.app.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="Advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Car car;

    @Column(name="profilePicture")
    private String profilePicture;

    @OneToMany(mappedBy = "advert",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Picture> pictureSet;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="startOfAdvert")
    private Date startOfAdvert;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="endOfAdvert")
    private Date endOfAdvert;

    @Column(name="description")
    private String description;

    @Column(name="isActive")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "email")
    private Client currentDriver;

    @OneToMany(mappedBy = "advert",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> comments;

}
