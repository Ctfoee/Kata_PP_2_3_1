package kata_task_2_3_1.controller;

import kata_task_2_3_1.dao.UserDao;
import kata_task_2_3_1.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @GetMapping("")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userDao.getAllUsers());
        return "users";
    }

}
