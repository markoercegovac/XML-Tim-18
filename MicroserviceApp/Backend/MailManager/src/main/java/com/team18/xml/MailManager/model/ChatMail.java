package com.team18.xml.MailManager.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMail implements Serializable {

	/**
	 * Message from Chat manager
	 */
	private static final long serialVersionUID = 1L;

	private String receiver;
	private String sender;
	private String header;
	private String content;
	
}