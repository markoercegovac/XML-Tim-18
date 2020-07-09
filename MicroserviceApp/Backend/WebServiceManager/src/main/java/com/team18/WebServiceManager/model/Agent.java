package com.team18.WebServiceManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long agentId;

	@Column(nullable = false)
	private String agentEmail;

	@Column(nullable = false)
	private String agentUrl;

	@OneToMany
	private List<Binding> bindings;
}
