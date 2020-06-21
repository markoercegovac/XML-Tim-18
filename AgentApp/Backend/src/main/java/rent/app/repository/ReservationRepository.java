package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
