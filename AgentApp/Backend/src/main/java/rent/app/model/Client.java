package rent.app.model;

import lombok.Data;
import rent.app.model.security.Role;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name="Client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String email;

    @Column(nullable=false)
    private String username;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String streetNumber;

    @Column
    private String password;

    @Column(nullable=true)
    private boolean isBanned;

    @Column(nullable = true)
    private boolean isRemoved;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;



    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Car> cars;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
}
