package chat.dto;

import lombok.Data;

@Data
public class SendMessageDTO {

    private String receiverEmail;
    private String senderEmail;
    private boolean ownerSending;
    private String header;
    private String content;
}
