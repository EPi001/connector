package de.sii.connector.user.tasks;

import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTask {

//    @Autowired
//    private UserServiceSettings userServiceSettings;

    private UserService userService;

    public UserTask(@Autowired UserService userService) {
        this.userService = userService;

        run();
    }

    @Scheduled(initialDelay=1000, fixedRate=12000)
    @Async
    public void run() {
        List<User> userList = userService.getUsersFromApi();
        userService.createUsers(userList);
    }

}
