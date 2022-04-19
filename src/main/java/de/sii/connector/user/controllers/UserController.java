package de.sii.connector.user.controllers;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import de.sii.connector.user.tasks.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceSettings userServiceSettings;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTask userTask;

    @GetMapping("/user")
    public String getUsers(Model model) {

        List<User> users = userService.getUsersFromRepository();

        model.addAttribute("users", users);

        return "user";
    }

    @PostConstruct
    public void init() {
        int period = userServiceSettings.getPeriod();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(userTask, 0, period, TimeUnit.SECONDS);
    }
}
