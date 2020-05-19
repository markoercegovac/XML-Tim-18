package rent.app.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private long commentId;
    private String content;
    private String author;
    private long advertId;
}
