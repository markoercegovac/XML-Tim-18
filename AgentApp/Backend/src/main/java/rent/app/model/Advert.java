package rent.app.model;

import lombok.Data;
import rent.app.dto.PictureDto;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="Advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Car car;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture profilePicture;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Picture> pictureSet;

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

    @Column
    private String city;


    @OneToOne(fetch = FetchType.LAZY)
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_driver", referencedColumnName = "email")
    private Client currentDriver;

    @OneToMany(mappedBy = "advert",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany
    private List<Reservation> reservations;


}
