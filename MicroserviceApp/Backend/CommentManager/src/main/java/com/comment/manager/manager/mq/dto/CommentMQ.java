package com.comment.manager.manager.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentMQ {

	protected Long id;
	protected Long advertId;
	protected String content;
	protected String header;
	protected Date creationDate;
	protected String userEmail;

}
