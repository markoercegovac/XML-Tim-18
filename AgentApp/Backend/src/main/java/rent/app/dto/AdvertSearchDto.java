package rent.app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import rent.app.model.Reservation;

import java.util.List;

@RequiredArgsConstructor
@Data
public class AdvertSearchDto implements DTOEntity {

    private Long advertCopyId;
    private String city;
    private String carMark;
    private String modelMark;
    private String carFuelType;
    private String carTransmissionType;
    private String carClass;
    private float priceFrom;
    private float priceTo;
    private float traveledKm;
    private float plannedKm;
    private String insurance;
    private int numberOfSeats;
    private String profilePicture;
    private float mark;
    private float price;
    private List<Reservation> carReservedDate;

    public AdvertSearchDto(String city, String carMark, String modelMark, String carClass, String carFuelType, String carTransmissionType, float price){
        this.city=city;
        this.carMark=carMark;
        this.carClass=carClass;
        this.carFuelType=carFuelType;
        this.modelMark=modelMark;
        this.carTransmissionType=carTransmissionType;
        this.price=price;

    }
}
