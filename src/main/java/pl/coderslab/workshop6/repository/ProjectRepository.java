package pl.coderslab.workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.workshop6.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findTop5ByOrderByCreatedDesc();

}
