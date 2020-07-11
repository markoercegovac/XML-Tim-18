package rent.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import rent.app.controller.ws.client.CarBrandClient;

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
	public CarBrandClient courseClient(Jaxb2Marshaller marshaller) {
		CarBrandClient client = new CarBrandClient();
		client.setDefaultUri("http://localhost:8099/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
