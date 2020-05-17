package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.model.CarBrand;

import java.util.List;

public interface CarBrandService {

    public List<CarBrand> getAllCarBrands();
}
