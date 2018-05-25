package pl.coderslab.workshop6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.workshop6.entity.Status;
import pl.coderslab.workshop6.entity.Task;
import pl.coderslab.workshop6.service.StatusService;
import pl.coderslab.workshop6.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StatusController {

    @Autowired
    StatusService statusService;

    @Autowired
    TaskService taskService;

    @GetMapping("/status/add")
    public String addStatus(Model model) {
        model.addAttribute("status",new Status());
        return "statusForm";
    }

    @PostMapping("status/add")
    public String addStatus(@Valid @ModelAttribute Status status) {
        statusService.saveStatus(status);
        return "redirect:/";
    }

    @GetMapping("status/show/all")
    public String showAllStatuss(Model model) {
        return "statusListAll";
    }

    @GetMapping("status/show/{status_id")
    public String showStatus(@PathVariable Long status_id, Model model) {
        model.addAttribute(statusService.findStatusById(status_id));
        return "statusShow";
    }

    @GetMapping("status/edit/{status_id}")
    public String editStatus(@PathVariable Long status_id, Model model) {
        Status status = statusService.findStatusById(status_id);
        model.addAttribute("status",status);
        return "statusForm";
    }

    @PostMapping("status/edit/{status_id}")
    public String editStatus(@ModelAttribute Status status,
                           @PathVariable Long status_id,
                           Model model) {
        status.setId(status_id);
        statusService.editStatus(status);
        return "redirect:/";
    }

    @GetMapping("status/delete/{status_id}")
    public String deleteStatus(@PathVariable Long status_id, Model model) {
        statusService.deleteStatus(statusService.findStatusById(status_id));
        return "redirect:/";
    }

    ////////////////////    MODEL ATTRIBUTES //////////////////

    @ModelAttribute("statusall")
    public List<Status> allStatus() {
        return statusService.findAllStatus();
    }

    @ModelAttribute("tasks")
    public List<Task> allTasks() {
        return taskService.findAllTasks();
    }


}
