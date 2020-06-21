package com.comment.manager.manager.model;

import com.comment.manager.manager.model.enums.CommentState;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long advertId;

    @Column
    private String userEmail;

    @Column
    private String header;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date creationDate;

    @Enumerated(EnumType.STRING)
    @Column
    private CommentState commentState;

}
