package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.security.Role;

public interface RoleRepository extends JpaRepository<Role,Long > {
}
