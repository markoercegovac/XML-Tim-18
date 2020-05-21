package chat.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ShortMessageDTO {

    private Long messageId;
    private Date creationDate;
    private String fromUser;
    private String header;
}
