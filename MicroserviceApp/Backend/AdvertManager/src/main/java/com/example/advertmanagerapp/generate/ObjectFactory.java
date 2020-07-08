//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.08 at 02:24:58 PM CEST 
//


package com.example.advertmanagerapp.generate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.advertmanagerapp.generate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCarBrandRequest_QNAME = new QName("http://uns.ac.rs/xml/team18/agent", "createCarBrandRequest");
    private final static QName _CreateCarBrandResponse_QNAME = new QName("http://uns.ac.rs/xml/team18/agent", "createCarBrandResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.advertmanagerapp.generate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCarBrandRequest }
     * 
     */
    public CreateCarBrandRequest createCreateCarBrandRequest() {
        return new CreateCarBrandRequest();
    }

    /**
     * Create an instance of {@link CreateCarBrandResponse }
     * 
     */
    public CreateCarBrandResponse createCreateCarBrandResponse() {
        return new CreateCarBrandResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarBrandRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCarBrandRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18/agent", name = "createCarBrandRequest")
    public JAXBElement<CreateCarBrandRequest> createCreateCarBrandRequest(CreateCarBrandRequest value) {
        return new JAXBElement<CreateCarBrandRequest>(_CreateCarBrandRequest_QNAME, CreateCarBrandRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarBrandResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCarBrandResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18/agent", name = "createCarBrandResponse")
    public JAXBElement<CreateCarBrandResponse> createCreateCarBrandResponse(CreateCarBrandResponse value) {
        return new JAXBElement<CreateCarBrandResponse>(_CreateCarBrandResponse_QNAME, CreateCarBrandResponse.class, null, value);
    }

}
