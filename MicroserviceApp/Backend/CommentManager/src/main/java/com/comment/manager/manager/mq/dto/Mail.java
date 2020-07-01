package com.comment.manager.manager.mq.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail implements Serializable {
	/**
	*{
	 * "ownerEmail": "pera@maildrop.cc",
	 * "userEmail": "mika@maildrop.cc",
	 * "comment": "This is just a test"
	 * }
	*/
	private static final long serialVersionUID = 1L;

	private String ownerEmail;
	private String userEmail;
	private String comment;
	
}