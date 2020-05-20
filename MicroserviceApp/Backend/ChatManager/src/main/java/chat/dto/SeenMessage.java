package chat.dto;

import lombok.Data;

@Data
public class SeenMessage {

    private Long messageId;
    private String userEmail;
}
