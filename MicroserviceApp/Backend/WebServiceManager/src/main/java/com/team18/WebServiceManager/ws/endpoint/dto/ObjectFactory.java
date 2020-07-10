package com.team18.WebServiceManager.ws.endpoint.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rent.app.controller.ws.generate package. 
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

    private final static QName _AdvertRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "advertRequest");
    private final static QName _CaptureRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "captureRequest");
    private final static QName _CarBrandRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carBrandRequest");
    private final static QName _CarClassRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carClassRequest");
    private final static QName _CarFuelTypeRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carFuelTypeRequest");
    private final static QName _CarModelRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carModelRequest");
    private final static QName _CarRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carRequest");
    private final static QName _CarTransmissionRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "carTransmissionRequest");
    private final static QName _ClientRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "clientRequest");
    private final static QName _CommentRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "commentRequest");
    private final static QName _DriveReportRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "driveReportRequest");
    private final static QName _GradeReport_QNAME = new QName("http://uns.ac.rs/xml/team18", "gradeReport");
    private final static QName _MessageRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "messageRequest");
    private final static QName _PictureRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "pictureRequest");
    private final static QName _PriceRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "priceRequest");
    private final static QName _ReservationRequest_QNAME = new QName("http://uns.ac.rs/xml/team18", "reservationRequest");
    private final static QName _SoapResponse_QNAME = new QName("http://uns.ac.rs/xml/team18", "soapResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rent.app.controller.ws.generate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdvertRequest }
     *
     */
    public AdvertRequest createAdvertRequest() {
        return new AdvertRequest();
    }

    /**
     * Create an instance of {@link CaptureRequest }
     * 
     */
    public CaptureRequest createCaptureRequest() {
        return new CaptureRequest();
    }

    /**
     * Create an instance of {@link CarBrandRequest }
     * 
     */
    public CarBrandRequest createCarBrandRequest() {
        return new CarBrandRequest();
    }

    /**
     * Create an instance of {@link CarClassRequest }
     * 
     */
    public CarClassRequest createCarClassRequest() {
        return new CarClassRequest();
    }

    /**
     * Create an instance of {@link CarFuelTypeRequest }
     * 
     */
    public CarFuelTypeRequest createCarFuelTypeRequest() {
        return new CarFuelTypeRequest();
    }

    /**
     * Create an instance of {@link CarModelRequest }
     * 
     */
    public CarModelRequest createCarModelRequest() {
        return new CarModelRequest();
    }

    /**
     * Create an instance of {@link CarRequest }
     * 
     */
    public CarRequest createCarRequest() {
        return new CarRequest();
    }

    /**
     * Create an instance of {@link CarTransmissionRequest }
     * 
     */
    public CarTransmissionRequest createCarTransmissionRequest() {
        return new CarTransmissionRequest();
    }

    /**
     * Create an instance of {@link ClientRequest }
     * 
     */
    public ClientRequest createClientRequest() {
        return new ClientRequest();
    }

    /**
     * Create an instance of {@link CommentRequest }
     * 
     */
    public CommentRequest createCommentRequest() {
        return new CommentRequest();
    }

    /**
     * Create an instance of {@link DriveReportRequest }
     * 
     */
    public DriveReportRequest createDriveReportRequest() {
        return new DriveReportRequest();
    }

    /**
     * Create an instance of {@link GradeReport }
     * 
     */
    public GradeReport createGradeReport() {
        return new GradeReport();
    }

    /**
     * Create an instance of {@link MessageRequest }
     * 
     */
    public MessageRequest createMessageRequest() {
        return new MessageRequest();
    }

    /**
     * Create an instance of {@link PictureRequest }
     * 
     */
    public PictureRequest createPictureRequest() {
        return new PictureRequest();
    }

    /**
     * Create an instance of {@link PriceRequest }
     * 
     */
    public PriceRequest createPriceRequest() {
        return new PriceRequest();
    }

    /**
     * Create an instance of {@link ReservationRequest }
     * 
     */
    public ReservationRequest createReservationRequest() {
        return new ReservationRequest();
    }

    /**
     * Create an instance of {@link SoapResponse }
     * 
     */
    public SoapResponse createSoapResponse() {
        return new SoapResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdvertRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AdvertRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "advertRequest")
    public JAXBElement<AdvertRequest> createAdvertRequest(AdvertRequest value) {
        return new JAXBElement<AdvertRequest>(_AdvertRequest_QNAME, AdvertRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaptureRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaptureRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "captureRequest")
    public JAXBElement<CaptureRequest> createCaptureRequest(CaptureRequest value) {
        return new JAXBElement<CaptureRequest>(_CaptureRequest_QNAME, CaptureRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarBrandRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarBrandRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carBrandRequest")
    public JAXBElement<CarBrandRequest> createCarBrandRequest(CarBrandRequest value) {
        return new JAXBElement<CarBrandRequest>(_CarBrandRequest_QNAME, CarBrandRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarClassRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarClassRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carClassRequest")
    public JAXBElement<CarClassRequest> createCarClassRequest(CarClassRequest value) {
        return new JAXBElement<CarClassRequest>(_CarClassRequest_QNAME, CarClassRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarFuelTypeRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarFuelTypeRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carFuelTypeRequest")
    public JAXBElement<CarFuelTypeRequest> createCarFuelTypeRequest(CarFuelTypeRequest value) {
        return new JAXBElement<CarFuelTypeRequest>(_CarFuelTypeRequest_QNAME, CarFuelTypeRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarModelRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarModelRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carModelRequest")
    public JAXBElement<CarModelRequest> createCarModelRequest(CarModelRequest value) {
        return new JAXBElement<CarModelRequest>(_CarModelRequest_QNAME, CarModelRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carRequest")
    public JAXBElement<CarRequest> createCarRequest(CarRequest value) {
        return new JAXBElement<CarRequest>(_CarRequest_QNAME, CarRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CarTransmissionRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CarTransmissionRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "carTransmissionRequest")
    public JAXBElement<CarTransmissionRequest> createCarTransmissionRequest(CarTransmissionRequest value) {
        return new JAXBElement<CarTransmissionRequest>(_CarTransmissionRequest_QNAME, CarTransmissionRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClientRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "clientRequest")
    public JAXBElement<ClientRequest> createClientRequest(ClientRequest value) {
        return new JAXBElement<ClientRequest>(_ClientRequest_QNAME, ClientRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CommentRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "commentRequest")
    public JAXBElement<CommentRequest> createCommentRequest(CommentRequest value) {
        return new JAXBElement<CommentRequest>(_CommentRequest_QNAME, CommentRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriveReportRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriveReportRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "driveReportRequest")
    public JAXBElement<DriveReportRequest> createDriveReportRequest(DriveReportRequest value) {
        return new JAXBElement<DriveReportRequest>(_DriveReportRequest_QNAME, DriveReportRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GradeReport }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GradeReport }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "gradeReport")
    public JAXBElement<GradeReport> createGradeReport(GradeReport value) {
        return new JAXBElement<GradeReport>(_GradeReport_QNAME, GradeReport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "messageRequest")
    public JAXBElement<MessageRequest> createMessageRequest(MessageRequest value) {
        return new JAXBElement<MessageRequest>(_MessageRequest_QNAME, MessageRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PictureRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PictureRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "pictureRequest")
    public JAXBElement<PictureRequest> createPictureRequest(PictureRequest value) {
        return new JAXBElement<PictureRequest>(_PictureRequest_QNAME, PictureRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriceRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PriceRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "priceRequest")
    public JAXBElement<PriceRequest> createPriceRequest(PriceRequest value) {
        return new JAXBElement<PriceRequest>(_PriceRequest_QNAME, PriceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservationRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReservationRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "reservationRequest")
    public JAXBElement<ReservationRequest> createReservationRequest(ReservationRequest value) {
        return new JAXBElement<ReservationRequest>(_ReservationRequest_QNAME, ReservationRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoapResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoapResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://uns.ac.rs/xml/team18", name = "soapResponse")
    public JAXBElement<SoapResponse> createSoapResponse(SoapResponse value) {
        return new JAXBElement<SoapResponse>(_SoapResponse_QNAME, SoapResponse.class, null, value);
    }

}
