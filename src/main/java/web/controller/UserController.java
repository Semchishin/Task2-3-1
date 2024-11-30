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

    @RequestMapping(value = "/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "user";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id", required = true) long id){
        model.addAttribute("editUser", userService.showUserById(id));
        return "edit";
    }
  @GetMapping("/new")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("addUser", user);
        return "userAdding";
    }
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("editUser") User user, @PathVariable("id") long id){
        userService.updateUser(id, user);
        return "redirect:/";
    }
    @PostMapping("/")
    public String create(@ModelAttribute("newUser") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


}
