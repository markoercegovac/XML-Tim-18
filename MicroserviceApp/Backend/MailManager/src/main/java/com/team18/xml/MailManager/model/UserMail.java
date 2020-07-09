package com.team18.xml.MailManager.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMail implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	private String email;
	private String companyName;
	private String name;
	private String surname;
	private boolean agent;
	
}