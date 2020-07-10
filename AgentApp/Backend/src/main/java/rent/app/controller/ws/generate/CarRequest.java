//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.10 at 11:04:57 AM CEST 
//


package rent.app.controller.ws.generate;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for carRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="carBrandId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="carModelId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="carClassId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="carFuelTypeId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="carTransmissionId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="traveledDistance" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="traveledDistanceConstraint" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="insurance" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="childrenSitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="deleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlRootElement(namespace = "http://uns.ac.rs/xml/team18")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carRequest", propOrder = {
    "id",
    "token",
    "carBrandId",
    "carModelId",
    "carClassId",
    "carFuelTypeId",
    "carTransmissionId",
    "traveledDistance",
    "traveledDistanceConstraint",
    "insurance",
    "childrenSitNumber",
    "deleted"
})
public class CarRequest {

    protected long id;
    @XmlElement(required = true)
    protected String token;
    protected long carBrandId;
    protected long carModelId;
    protected long carClassId;
    protected long carFuelTypeId;
    protected long carTransmissionId;
    protected long traveledDistance;
    protected long traveledDistanceConstraint;
    protected boolean insurance;
    protected int childrenSitNumber;
    protected boolean deleted;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the carBrandId property.
     * 
     */
    public long getCarBrandId() {
        return carBrandId;
    }

    /**
     * Sets the value of the carBrandId property.
     * 
     */
    public void setCarBrandId(long value) {
        this.carBrandId = value;
    }

    /**
     * Gets the value of the carModelId property.
     * 
     */
    public long getCarModelId() {
        return carModelId;
    }

    /**
     * Sets the value of the carModelId property.
     * 
     */
    public void setCarModelId(long value) {
        this.carModelId = value;
    }

    /**
     * Gets the value of the carClassId property.
     * 
     */
    public long getCarClassId() {
        return carClassId;
    }

    /**
     * Sets the value of the carClassId property.
     * 
     */
    public void setCarClassId(long value) {
        this.carClassId = value;
    }

    /**
     * Gets the value of the carFuelTypeId property.
     * 
     */
    public long getCarFuelTypeId() {
        return carFuelTypeId;
    }

    /**
     * Sets the value of the carFuelTypeId property.
     * 
     */
    public void setCarFuelTypeId(long value) {
        this.carFuelTypeId = value;
    }

    /**
     * Gets the value of the carTransmissionId property.
     * 
     */
    public long getCarTransmissionId() {
        return carTransmissionId;
    }

    /**
     * Sets the value of the carTransmissionId property.
     * 
     */
    public void setCarTransmissionId(long value) {
        this.carTransmissionId = value;
    }

    /**
     * Gets the value of the traveledDistance property.
     * 
     */
    public long getTraveledDistance() {
        return traveledDistance;
    }

    /**
     * Sets the value of the traveledDistance property.
     * 
     */
    public void setTraveledDistance(long value) {
        this.traveledDistance = value;
    }

    /**
     * Gets the value of the traveledDistanceConstraint property.
     * 
     */
    public long getTraveledDistanceConstraint() {
        return traveledDistanceConstraint;
    }

    /**
     * Sets the value of the traveledDistanceConstraint property.
     * 
     */
    public void setTraveledDistanceConstraint(long value) {
        this.traveledDistanceConstraint = value;
    }

    /**
     * Gets the value of the insurance property.
     * 
     */
    public boolean isInsurance() {
        return insurance;
    }

    /**
     * Sets the value of the insurance property.
     * 
     */
    public void setInsurance(boolean value) {
        this.insurance = value;
    }

    /**
     * Gets the value of the childrenSitNumber property.
     * 
     */
    public int getChildrenSitNumber() {
        return childrenSitNumber;
    }

    /**
     * Sets the value of the childrenSitNumber property.
     * 
     */
    public void setChildrenSitNumber(int value) {
        this.childrenSitNumber = value;
    }

    /**
     * Gets the value of the deleted property.
     * 
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the value of the deleted property.
     * 
     */
    public void setDeleted(boolean value) {
        this.deleted = value;
    }

}
