//package com.example.advertmanagerapp.config;
//
//import com.example.advertmanagerapp.client.SoapClientCarBrand;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class SoapClientConfig {
//
//    @Value("${soap.agent.url}")
//    private String soapUrl;
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.example.advertmanagerapp.generate");
//
//        return marshaller;
//    }
//
//    @Bean
//    public SoapClientCarBrand carBrandClient(Jaxb2Marshaller marshaller) {
//        SoapClientCarBrand client = new SoapClientCarBrand();
//        client.setDefaultUri("http://localhost:9091/ws");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }
//}
