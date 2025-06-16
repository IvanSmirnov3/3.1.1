package web.Proj311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.Proj311.model.User;
import web.Proj311.service.UserService;


import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "/updateUser")
    public String updateUser(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", userService.findByIdUser(id));
        return "updateUser";
    }

    @PostMapping(value = "/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteByIdUser(id);
        return "redirect:/";
    }
}
