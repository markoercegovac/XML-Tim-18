package com.example.request.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MailMessage {
	
	String reciver;
	String header;
	String content;
}