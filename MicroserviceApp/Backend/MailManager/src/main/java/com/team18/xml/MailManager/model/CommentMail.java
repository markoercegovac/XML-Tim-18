package com.team18.xml.MailManager.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentMail implements Serializable {
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