package rent.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rent.app.model.security.Permission;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
