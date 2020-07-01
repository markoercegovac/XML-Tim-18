package com.team18.xml.MailManager.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMail implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = -3279074586904728522L;

	private String ownerEmail;
	private String userEmail;
	private String bundleStatus;
	
}