package rent.app.controller.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rent.app.controller.ws.WSEndpoint;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WSEndpoint.NAMESPACE_URI)
@XmlType(name = "createCarBrandRequest", propOrder = {
        "name",
        "isRemoved"
}, namespace = WSEndpoint.NAMESPACE_URI)
public class CreateCarBrandRequest {

    @XmlElement(required = true)
    protected String name;

    @XmlElement(required = true)
    protected boolean isRemoved;

}
