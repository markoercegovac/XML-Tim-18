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
@XmlType(name = "createCarBrandResponse", propOrder = {
        "status"
}, namespace = WSEndpoint.NAMESPACE_URI)
public class CreateCarBrandResponse {

    @XmlElement(required = true)
    protected String status;
}
