package chat.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LongMessageDTO {

    private Long messageId;
    private String receiverEmail;
    private String senderEmail;
    private String header;
    private String content;
    private Date creationDate;
}
