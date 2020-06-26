package rent.app.dto;

import lombok.Data;

@Data
public class RequestDto {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String Role;
}
