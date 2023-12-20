package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute("user") User user, ModelMap model) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        return "usercreated";
    }

    @GetMapping(value = "/get")
    public String getUserById(@RequestParam(value = "id") Integer id, ModelMap model) {
        if (id == null) {
            return "notfound";
        }
        User user = userService.getUser(id);
        if (user == null) {
            return "notfound";
        }
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping(value = "/getall")
    public String getUsers(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "allusersinfo";
    }

    @GetMapping(value = "/")
    public String home() {
        return "forward:/getall";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User newUser, @RequestParam(value = "id") Integer id) {
        if (id == null  || userService.getUser(id) == null) {
            return "notfound";
        }
        userService.updateUser(id,
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail(),
                newUser.getAge());
        return "userupdated";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Integer id) {
        if (id == null  || userService.getUser(id) == null) {
            return "notfound";
        }
        userService.deleteUser(id);
        return "userdeleted";
    }
}
