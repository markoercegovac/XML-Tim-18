package com.team18.WebServiceManager;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarBrandRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class WebServiceManagerApplicationTests {

	@Autowired
	private CarBrandRepository carBrandRepository;
	@Autowired
	private AgentRepository agentRepository;

	@Test
	void contextLoads() {
		String t = "car-{neto}";
		String[] a = t.split("-");

		System.out.println("PISI MI");
		System.out.println(a[0]);
		System.out.println(a[1]);
	}

	@Test
	public void t() {
		Agent a = new Agent();
		a.setAgentUrl("url");
		a.setAgentEmail("bla@com");
		agentRepository.save(a);
		CarBrand b = new CarBrand();
		b.setAgent(a);
		b.setKeyAG(101l);
		b.setKeyMS(501l);
		carBrandRepository.save(b);
		CarBrand b1 = new CarBrand();
		b1.setAgent(a);
		b1.setKeyAG(102l);
		b1.setKeyMS(502l);
		carBrandRepository.save(b1);

		CarBrand f = carBrandRepository.findByAgentAgentIdAndKeyAG(1l, 101l);
		System.out.println("------> "+ f.getKeyMS());
		assert (f.getKeyMS().equals(501l));

		CarBrand f1 = carBrandRepository.findByAgentAgentIdAndKeyAG(1l, 103l);
		System.out.println("------> "+ f1);
	}

	@Test
	public void max() {
		Agent a = new Agent();
		a.setAgentUrl("url");
		a.setAgentEmail("bla@com");
		agentRepository.save(a);
		CarBrand b = new CarBrand();
		b.setAgent(a);
		b.setKeyAG(101l);
		b.setKeyMS(501l);
		carBrandRepository.save(b);
		CarBrand b1 = new CarBrand();
		b1.setAgent(a);
		b1.setKeyAG(102l);
		b1.setKeyMS(502l);
		carBrandRepository.save(b1);

		List<CarBrand> found = carBrandRepository.findByAgentAgentIdOrderByKeyMSDesc(1l);
		for(CarBrand f : found) {
			System.out.println("------> "+ f.getKeyMS());
		}
	}


}
