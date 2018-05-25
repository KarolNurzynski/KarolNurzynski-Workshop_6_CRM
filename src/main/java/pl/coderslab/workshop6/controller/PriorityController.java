package pl.coderslab.workshop6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.workshop6.entity.Priority;
import pl.coderslab.workshop6.entity.Task;
import pl.coderslab.workshop6.service.PriorityService;
import pl.coderslab.workshop6.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PriorityController {

    @Autowired
    PriorityService priorityService;

    @Autowired
    TaskService taskService;

    @GetMapping("/priority/add")
    public String addPriority(Model model) {
        model.addAttribute("priority",new Priority());
        return "priorityForm";
    }

    @PostMapping("priority/add")
    public String addPriority(@Valid @ModelAttribute Priority priority) {
        priorityService.savePriority(priority);
        return "redirect:/";
    }

    @GetMapping("priority/show/all")
    public String showAllPrioritys(Model model) {
        return "priorityListAll";
    }

    @GetMapping("priority/show/{priority_id")
    public String showPriority(@PathVariable Long priority_id, Model model) {
        model.addAttribute(priorityService.findPriorityById(priority_id));
        return "priorityShow";
    }

    @GetMapping("priority/edit/{priority_id}")
    public String editPriority(@PathVariable Long priority_id, Model model) {
        Priority priority = priorityService.findPriorityById(priority_id);
        model.addAttribute("priority",priority);
        System.out.println("============");
        return "priorityForm";
    }

    @PostMapping("priority/edit/{priority_id}")
    public String editPriority(@ModelAttribute Priority priority,
                           @PathVariable Long priority_id,
                           Model model) {
        priority.setId(priority_id);
        System.out.println(priority.getId());
        priorityService.editPriority(priority);
        System.out.println(priority.getId());
        return "redirect:/";
    }

    @GetMapping("priority/delete/{priority_id}")
    public String deletePriority(@PathVariable Long priority_id, Model model) {
        priorityService.deletePriority(priorityService.findPriorityById(priority_id));
        return "redirect:/";
    }

    ////////////////////    MODEL ATTRIBUTES //////////////////

    @ModelAttribute("priorities")
    public List<Priority> allPrioritiess() {
        return priorityService.findAllPriorities();
    }

    @ModelAttribute("tasks")
    public List<Task> allTasks() {
        return taskService.findAllTasks();
    }

}
