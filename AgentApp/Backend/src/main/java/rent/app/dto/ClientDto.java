package rent.app.dto;

import lombok.Data;

@Data
public class ClientDto implements DTOEntity{
    private String email;
    private String username;
    private String name;
    private String surname;
    private String state;
    private String city;
    private String street;
    private String streetNumber;
    private String password;
    private String isBanned;
    private String isRemoved;
    private String companyName;
    private String companyRegistrationNumber;
}
