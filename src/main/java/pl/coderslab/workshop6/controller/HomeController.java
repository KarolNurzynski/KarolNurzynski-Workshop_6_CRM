package pl.coderslab.workshop6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.workshop6.entity.Project;
import pl.coderslab.workshop6.service.ProjectService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/")
    public String home() {
        return "home";
    }



    /////////////////////////    MODEL ATTRIBUTES   /////////////////////////////////

    @ModelAttribute("projects")
    public List<Project> projects() {
        return projectService.findAllProjects();
    }

    @ModelAttribute("last5projects")
    public List<Project> last5projects() {
        return projectService.findLast5Projects();
    }
}
