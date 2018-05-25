package pl.coderslab.workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.entity.Priority;
import pl.coderslab.workshop6.entity.Status;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status,Long> {

    List<Status> findAllByActiveStatusIsTrue();

}
