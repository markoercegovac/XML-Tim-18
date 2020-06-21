package rent.app.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private Long commentId;
    private String content;
    private String author;
    private Long advertId;
}
