package rent.app.service;

import rent.app.model.CarTransmissionType;

import java.util.List;

public interface CarTranssmisionTypeService {

    public void deleteCarTranssmision(Long id);
    public void saveCarTranssmisionType(CarTransmissionType carTransmissionType);
    public List<CarTransmissionType> getAllCarTranssmisionType();
}
