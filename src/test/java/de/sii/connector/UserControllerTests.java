package de.sii.connector;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.controllers.UserController;
import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import de.sii.connector.user.tasks.UserTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private UserServiceSettings userServiceSettings;

    @MockBean
    private UserService userService;

    @MockBean
    private UserTask userTask;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUsersTest() throws Exception {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();

        user1.setName("Name1");
        user1.setGender("male1");
        user1.setLocation("Location1");
        user1.setEmail("user1@example.com");

        user2.setName("Name2");
        user2.setGender("female2");
        user2.setLocation("Location2");
        user2.setEmail("user2@example.com");


        users.add(user1);
        users.add(user2);

        when(userService.getUsersFromRepository()).thenReturn(users);
        // TODO
        mockMvc.perform(post("/user")
                        .content("")
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(""));


    }

    @Test
    public void initTest() {

    }
}
