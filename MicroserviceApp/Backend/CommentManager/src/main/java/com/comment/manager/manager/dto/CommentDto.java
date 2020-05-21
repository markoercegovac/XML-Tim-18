package com.comment.manager.manager.dto;

import com.comment.manager.manager.model.enums.CommentState;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long advertId;
    private Long userEmail;
    private String header;
    private String content;
    private String creationDate;
    private CommentState commentState;
}
