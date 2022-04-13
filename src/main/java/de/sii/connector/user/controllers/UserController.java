package de.sii.connector.user.controllers;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceSettings userServiceSettings;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUsers(Model model) {

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "user";
    }

}
