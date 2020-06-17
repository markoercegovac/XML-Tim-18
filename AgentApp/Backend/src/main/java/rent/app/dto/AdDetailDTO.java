package rent.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdDetailDTO {
	
	//fali set imagesa
	public Long adId;
	public Long carId;
	public byte[] profileImage;
	public Date startOfAdvert;
	public Date endOfAdvert;
	public String description;
}