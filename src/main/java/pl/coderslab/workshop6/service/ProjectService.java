package pl.coderslab.workshop6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.workshop6.entity.Project;
import pl.coderslab.workshop6.entity.Project;
import pl.coderslab.workshop6.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    ProjectRepository projectRepository;

    @Autowired
    ProjectService(ProjectRepository projectRepository) {
        this.projectRepository=projectRepository;
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> findLast5Projects() {
        return projectRepository.findTop5ByOrderByCreatedDesc();
    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id).orElseGet(null);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project editProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }
}
