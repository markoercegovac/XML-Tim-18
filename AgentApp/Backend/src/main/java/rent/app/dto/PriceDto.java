package rent.app.dto;

import lombok.Data;

@Data
public class PriceDto implements DTOEntity {
    private Long id;
    private String name;
    private float pricePerDay;
    private float insurancePrice;
    private float distanceOverflowPrice;
    private float discount;
    private boolean isRemoved;
}
