package rent.app.model;

import lombok.Data;
import rent.app.model.security.Role;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


@Data
@Entity
@Table
public class Client implements Serializable {


    @Id
    private String email;

    @Column(nullable=false)
    private String username;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String streetNumber;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean isBanned;

    @Column
    private boolean isRemoved;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @OneToMany
    private List<Advert> advertList;

    @OneToMany
    private List<Price> priceList;

    @OneToMany
    private List<Car> carList;

    @OneToMany
    private List<Comment> comments;
}
