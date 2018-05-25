package pl.coderslab.workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
