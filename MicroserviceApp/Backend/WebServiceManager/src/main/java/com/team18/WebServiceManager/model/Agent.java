package com.team18.WebServiceManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long agentId;

	@Column(nullable = false, unique = true)
	private String agentEmail;

	@Column(nullable = false)
	private String agentUrl;
}
