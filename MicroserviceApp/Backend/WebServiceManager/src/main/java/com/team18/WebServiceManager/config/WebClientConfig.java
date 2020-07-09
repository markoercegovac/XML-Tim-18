package com.team18.WebServiceManager.config;

import com.team18.WebServiceManager.ws.client.CarBrandWSClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.team18.WebServiceManager.ws.dto");

		return marshaller;
	}

	//ISPOD IDE PO JEDAN BEAN ZA SVAKOG CLIENTA

	@Bean
	public CarBrandWSClient courseClient(Jaxb2Marshaller marshaller) {
		CarBrandWSClient client = new CarBrandWSClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
