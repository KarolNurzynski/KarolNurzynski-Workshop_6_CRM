package pl.coderslab.workshop6.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.workshop6.entity.Project;
import pl.coderslab.workshop6.entity.User;
import pl.coderslab.workshop6.service.ProjectService;
import pl.coderslab.workshop6.service.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @GetMapping("/project/add")
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    @PostMapping("/project/add")
    public String addProject(@Valid @ModelAttribute Project project,
                             BindingResult result){
        if (result.hasErrors()) {
            return "projectForm";
        }
        project.setCreated(LocalDateTime.now());
        project.setActiveStatus(true);
        project.setProjectId(StringUtils.stripAccents(project.getName()).replaceAll("\\s+","-"));
        projectService.saveProject(project);
        return "redirect:/";
    }

    @GetMapping("project/show/all")
    public String showAllProjects(Model model) {
        return "projectListAll";
    }

    @GetMapping("project/show/{project_id")
    public String showProject(@PathVariable Long project_id, Model model) {
        model.addAttribute(projectService.findProjectById(project_id));
        return "projectShow";
    }

    @GetMapping("project/edit/{project_id}")
    public String editProject(@PathVariable Long project_id, Model model) {
        Project project = projectService.findProjectById(project_id);
        model.addAttribute("project",project);
        return "projectEditForm";
    }

    @PostMapping("project/edit/{project_id}")
    public String editProject(@ModelAttribute Project project,
                           @PathVariable Long project_id,
                           Model model) {
        project.setId(project_id);
        projectService.editProject(project);
        return "redirect:/";
    }

    @GetMapping("project/delete/{project_id}")
    public String deleteProject(@PathVariable Long project_id, Model model) {
        projectService.deleteProject(projectService.findProjectById(project_id));
        return "redirect:/";
    }


    /////////////////////////    MODEL ATTRIBUTES   /////////////////////////////////

    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAllUsers();
    }

    @ModelAttribute("projects")
    public List<Project> projects() {
        return projectService.findAllProjects();
    }

}
