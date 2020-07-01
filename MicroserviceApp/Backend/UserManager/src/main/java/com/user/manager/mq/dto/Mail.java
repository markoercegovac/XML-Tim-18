package com.user.manager.mq.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;

	private String userEmail;
	private String password;
	private String companyName;
	private String token;
	
}