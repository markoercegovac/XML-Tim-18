package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Price;

public interface PriceRepository extends JpaRepository<Price,Long> {
    Price findAllById(Long priceId);
}
