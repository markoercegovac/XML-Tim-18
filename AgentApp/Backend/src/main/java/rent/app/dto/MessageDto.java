package rent.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDto implements DTOEntity {
    private Long id;
    private String title;
    private String content;
    private String sender;
    private String recipient;
    private Date date;
}
