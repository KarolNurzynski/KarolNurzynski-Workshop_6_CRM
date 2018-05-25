package pl.coderslab.workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
