package rent.app.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdCreateDTO {

	//fali set imagesa
	public Long carId;
	public String profileImage;
	public Date startOfAdvert;
	public Date endOfAdvert;
	public String description;
}