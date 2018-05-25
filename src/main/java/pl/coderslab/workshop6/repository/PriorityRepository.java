package pl.coderslab.workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.entity.Priority;
import pl.coderslab.workshop6.entity.Status;
import pl.coderslab.workshop6.entity.Task;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority,Long> {

    List<Priority> findAllByActiveStatusIsTrue();

}
