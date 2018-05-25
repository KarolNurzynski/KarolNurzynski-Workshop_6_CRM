package pl.coderslab.workshop6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.workshop6.entity.User;
import pl.coderslab.workshop6.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/add")
    public String addUser(Model model) {
        model.addAttribute("user",new User());
        return "userForm";
    }

    @PostMapping("user/add")
    public String addUser(@Valid @ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user/show/all")
    public String showAllUsers(Model model) {
        return "userListAll";
    }

    @GetMapping("user/show/{user_id")
    public String showUser(@PathVariable Long user_id, Model model) {
        model.addAttribute(userService.findUserById(user_id));
        return "userShow";
    }

    @GetMapping("user/edit/{user_id}")
    public String editUser(@PathVariable Long user_id, Model model) {
        User user = userService.findUserById(user_id);
        model.addAttribute("user",user);
        return "userForm";
    }

    @PostMapping("user/edit/{user_id}")
    public String editUser(@ModelAttribute User user,
                           @PathVariable Long user_id,
                           Model model) {
        user.setId(user_id);
        userService.editUser(user);
        return "redirect:/";
    }

    @GetMapping("user/delete/{user_id}")
    public String deleteUser(@PathVariable Long user_id, Model model) {
        userService.deleteUser(userService.findUserById(user_id));
        return "redirect:/";
    }

    ////////////////////    MODEL ATTRIBUTES //////////////////

    @ModelAttribute("users")
    public List<User> allUsers() {
        return userService.findAllUsers();
    }

}
