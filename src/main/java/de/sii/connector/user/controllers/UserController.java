package de.sii.connector.user.controllers;

import de.sii.connector.config.UserServiceSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserServiceSettings userServiceSettings;



}
