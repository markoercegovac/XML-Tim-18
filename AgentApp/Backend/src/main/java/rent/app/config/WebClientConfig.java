 package rent.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import rent.app.controller.ws.client.*;
import rent.app.model.CarTransmissionType;

 @Configuration
public class WebClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("rent.app.controller.ws.generate");

		return marshaller;
	}

	//ISPOD IDE PO JEDAN BEAN ZA SVAKOG CLIENTA
	@Bean
	public CarBrandClient carBrandSoapBean(Jaxb2Marshaller marshaller) {
		CarBrandClient client = new CarBrandClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarModelClient carModelSoapBean(Jaxb2Marshaller marshaller){
		CarModelClient client=new CarModelClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarClient carSoapBean(Jaxb2Marshaller marshaller){
		CarClient client=new CarClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public AdvertClient advertSoapBean(Jaxb2Marshaller marshaller){
		AdvertClient client=new AdvertClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CarClassClient carClassSoapBean(Jaxb2Marshaller marshaller){
		CarClassClient client=new CarClassClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public CarFuelTypeClient carFuelTypeSoapBean(Jaxb2Marshaller marshaller){
		CarFuelTypeClient client=new CarFuelTypeClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public CarTransmissionClient carTransmissionSoapBean(Jaxb2Marshaller marshaller){
		CarTransmissionClient client=new CarTransmissionClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public PictureClient pictureSoapBean(Jaxb2Marshaller marshaller){
		PictureClient client=new PictureClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	@Bean
	public PriceClient priceSoapBean(Jaxb2Marshaller marshaller){
		PriceClient client=new PriceClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public CommentClient commentSoapBean(Jaxb2Marshaller marshaller){
		CommentClient client =new CommentClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	 public DriverReportClient driverReportClient(Jaxb2Marshaller marshaller){
		DriverReportClient client=new DriverReportClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
