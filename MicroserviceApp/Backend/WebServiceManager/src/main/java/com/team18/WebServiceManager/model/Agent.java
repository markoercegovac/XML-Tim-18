package com.team18.WebServiceManager.model;


import javax.persistence.*;


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

	public Long getAgentId() {
		return agentId;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public String getAgentUrl() {
		return agentUrl;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public void setAgentUrl(String agentUrl) {
		this.agentUrl = agentUrl;
	}
}
