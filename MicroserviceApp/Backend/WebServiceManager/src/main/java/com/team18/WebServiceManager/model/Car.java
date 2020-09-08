package com.team18.WebServiceManager.model;


import javax.persistence.*;

@Entity
@Table
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long keyMS;

	@Column(nullable = false)
	private Long keyAG;

	@ManyToOne
	private Agent agent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKeyMS() {
		return keyMS;
	}

	public void setKeyMS(Long keyMS) {
		this.keyMS = keyMS;
	}

	public Long getKeyAG() {
		return keyAG;
	}

	public void setKeyAG(Long keyAG) {
		this.keyAG = keyAG;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
