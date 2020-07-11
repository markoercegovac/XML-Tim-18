package com.team18.WebServiceManager.config;

import com.team18.WebServiceManager.ws.client.CarBrandWSClient;
import com.team18.WebServiceManager.ws.client.CommentWSClinet;
import com.team18.WebServiceManager.ws.client.ReservationWSClinet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.team18.WebServiceManager.ws.endpoint.dto");

		return marshaller;
	}

	//ISPOD IDE PO JEDAN BEAN ZA SVAKOG CLIENTA

	@Bean
	public CarBrandWSClient carBrandWSClientBean(Jaxb2Marshaller marshaller) {
		CarBrandWSClient client = new CarBrandWSClient();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public CommentWSClinet commentWSClinetBean(Jaxb2Marshaller marshaller) {
		CommentWSClinet client = new CommentWSClinet();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public ReservationWSClinet reservationWSClinetBean(Jaxb2Marshaller marshaller) {
		ReservationWSClinet client = new ReservationWSClinet();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
