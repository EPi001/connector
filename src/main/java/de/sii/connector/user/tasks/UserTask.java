package de.sii.connector.user.tasks;

import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTask implements Runnable {

    @Autowired
    private UserService userService;

    public void run() {
        System.out.println("execute user task ...");
        List<User> userList = userService.getUsersFromApi();
        userService.createUsers(userList);
    }
}
