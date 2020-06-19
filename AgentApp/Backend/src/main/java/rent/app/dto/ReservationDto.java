package rent.app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationDto implements DTOEntity {
    private Long id;
    private Date takeDate;
    private Date leaveDate;
    private Long advertId;
}
