package kata_task_2_3_1.controller;

import kata_task_2_3_1.model.User;
import kata_task_2_3_1.service.UserService;
import kata_task_2_3_1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    // Create
    @GetMapping("/addNew")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "addNew";
    }

    @PostMapping("/addNew")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    //Read
    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getSingleUser(id));
        return "singleUser";
    }

    //Update
    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getSingleUser(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
