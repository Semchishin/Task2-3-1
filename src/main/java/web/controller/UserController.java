package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "user";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(value = "id") long id) {
        model.addAttribute("editUser", userService.showUserById(id));
        return "edit";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("addUser", user);
        return "userAdding";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("editUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("newUser") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
