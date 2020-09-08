package com.team18.WebServiceManager.config;

import com.team18.WebServiceManager.ws.client.CarBrandWSClient;
import com.team18.WebServiceManager.ws.client.CommentWSClinet;
import com.team18.WebServiceManager.ws.client.ReservationWSClinet;;
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
	public CarBrandWSClient carBrandWSClient(Jaxb2Marshaller marshaller) {
		CarBrandWSClient client = new CarBrandWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public AdvertWSClient advertWSClient(Jaxb2Marshaller marshaller) {
		AdvertWSClient client = new AdvertWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CaptureWSClient captureWSClient(Jaxb2Marshaller marshaller) {
		CaptureWSClient client = new CaptureWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarClassWSClient carClassWSClient(Jaxb2Marshaller marshaller) {
		CarClassWSClient client = new CarClassWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarFuelTypeWSClient carFuelTypeWSClient(Jaxb2Marshaller marshaller) {
		CarFuelTypeWSClient client = new CarFuelTypeWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarModelWSClient CcrModelWSClient(Jaxb2Marshaller marshaller) {
		CarModelWSClient client = new CarModelWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarTransmissionWSClient carTransmissionWSClient(Jaxb2Marshaller marshaller) {
		CarTransmissionWSClient client = new CarTransmissionWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarWSClient CcrWSClient(Jaxb2Marshaller marshaller) {
		CarWSClient client = new CarWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public PictureWSClient pictureWSClient(Jaxb2Marshaller marshaller) {
		PictureWSClient client = new PictureWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public PriceWSClient priceWSClient(Jaxb2Marshaller marshaller) {
		PriceWSClient client = new PriceWSClient();
		client.setMarshaller(marshaller); //marshaller prevodi iz jave u xml i obrnuto
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public CommentWSClinet commentWSClinet(Jaxb2Marshaller marshaller) {
		CommentWSClinet client = new CommentWSClinet();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public ReservationWSClinet ReservationWSClinet(Jaxb2Marshaller marshaller) {
		ReservationWSClinet client = new ReservationWSClinet();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
