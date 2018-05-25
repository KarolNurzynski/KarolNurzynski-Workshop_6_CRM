package pl.coderslab.workshop6.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.workshop6.entity.*;
import pl.coderslab.workshop6.service.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;

    @Autowired
    PriorityService priorityService;

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @GetMapping("/task/add")
    public String addTask(Model model) {
        model.addAttribute("task",new Task());
        return "taskForm";
    }

    @PostMapping("task/add")
    public String addTask(@Valid @ModelAttribute Task task) {
        task.setCreated(LocalDateTime.now());
        taskService.saveTask(task);
        return "redirect:/";
    }

    @GetMapping("task/show/all")
    public String showAllTasks(Model model) {
        return "taskListAll";
    }

    @GetMapping("task/show/{task_id")
    public String showTask(@PathVariable Long task_id, Model model) {
        model.addAttribute(taskService.findTaskById(task_id));
        return "taskShow";
    }

    @GetMapping("task/edit/{task_id}")
    public String editTask(@PathVariable Long task_id, Model model) {
        Task task = taskService.findTaskById(task_id);
        model.addAttribute("task",task);
        return "taskForm";
    }

    @PostMapping("task/edit/{task_id}")
    public String editTask(@ModelAttribute Task task,
                           @PathVariable Long task_id,
                           Model model) {
        task.setId(task_id);
        taskService.editTask(task);
        return "redirect:/";
    }

    @GetMapping("task/delete/{task_id}")
    public String deleteTask(@PathVariable Long task_id, Model model) {
        taskService.deleteTask(taskService.findTaskById(task_id));
        return "redirect:/";
    }

    ////////////////////    MODEL ATTRIBUTES //////////////////

    @ModelAttribute("projects")
    public List<Project> allProjects() {
        return projectService.findAllProjects();
    }

    @ModelAttribute("priorities")
    public List<Priority> allPriorities() {
        return priorityService.findAllPriorities();
    }

    @ModelAttribute("prioritiesactive")
    public List<Priority> allActivePriorities() {
        return priorityService.findAllActivePriorities();
    }


    @ModelAttribute("statusall")
    public List<Status> allStatus() {
        return statusService.findAllStatus();
    }

    @ModelAttribute("statusallactive")
    public List<Status> allactiveStatus() {
        return statusService.findAllActiveStatus();
    }

    @ModelAttribute("users")
    public List<User> allUsers() {
        return userService.findAllUsers();
    }

    @ModelAttribute("tasks")
    public List<Task> allTasks() {
        return taskService.findAllTasks();
    }



}
