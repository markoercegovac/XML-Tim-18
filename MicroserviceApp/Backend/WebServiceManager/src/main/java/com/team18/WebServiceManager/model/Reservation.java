package com.team18.WebServiceManager.model;

import javax.persistence.*;

@Entity
@Table
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long keyMS;

	@Column(nullable = false)
	private Long keyAG;

	@ManyToOne
	private Agent agent;

	public void setId(Long id) {
		this.id = id;
	}

	public void setKeyMS(Long keyMS) {
		this.keyMS = keyMS;
	}

	public void setKeyAG(Long keyAG) {
		this.keyAG = keyAG;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Long getId() {
		return id;
	}

	public Long getKeyMS() {
		return keyMS;
	}

	public Long getKeyAG() {
		return keyAG;
	}

	public Agent getAgent() {
		return agent;
	}
}
