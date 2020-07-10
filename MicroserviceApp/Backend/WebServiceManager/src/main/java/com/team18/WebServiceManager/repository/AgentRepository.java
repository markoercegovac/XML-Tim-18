package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
	Agent findByAgentEmail(String email);
}
