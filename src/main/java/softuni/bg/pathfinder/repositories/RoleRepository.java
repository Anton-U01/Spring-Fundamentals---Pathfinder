package softuni.bg.pathfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.pathfinder.models.Role;
import softuni.bg.pathfinder.models.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(UserRole name);
}
