package com.team18.WebServiceManager.config;

import com.team18.WebServiceManager.model.CarFuelType;
import com.team18.WebServiceManager.model.CarTransmission;
import com.team18.WebServiceManager.ws.client.*;
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
	public CarBrandWSClient courseClient(Jaxb2Marshaller marshaller) {
		CarBrandWSClient client = new CarBrandWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public AdvertWSClient course1Client(Jaxb2Marshaller marshaller) {
		AdvertWSClient client = new AdvertWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CaptureWSClient course2Client(Jaxb2Marshaller marshaller) {
		CaptureWSClient client = new CaptureWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarClassWSClient course3Client(Jaxb2Marshaller marshaller) {
		CarClassWSClient client = new CarClassWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarFuelTypeWSClient course4Client(Jaxb2Marshaller marshaller) {
		CarFuelTypeWSClient client = new CarFuelTypeWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarModelWSClient course5Client(Jaxb2Marshaller marshaller) {
		CarModelWSClient client = new CarModelWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarTransmissionWSClient course6Client(Jaxb2Marshaller marshaller) {
		CarTransmissionWSClient client = new CarTransmissionWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarWSClient course7Client(Jaxb2Marshaller marshaller) {
		CarWSClient client = new CarWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public PictureWSClient course8Client(Jaxb2Marshaller marshaller) {
		PictureWSClient client = new PictureWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public PriceWSClient course9Client(Jaxb2Marshaller marshaller) {
		PriceWSClient client = new PriceWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}
}
