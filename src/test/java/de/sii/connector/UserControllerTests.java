package de.sii.connector;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.controllers.UserController;
import de.sii.connector.user.models.User;
import de.sii.connector.user.services.UserService;
import de.sii.connector.user.tasks.UserTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@AutoConfigureWebClient /* Contexts could not be loaded */
@WebMvcTest(UserController.class)
@ComponentScan(basePackages = {"de.sii.connector.config"}) /* Configuration could not be found */
public class UserControllerTests {

    @Autowired
    private UserServiceSettings userServiceSettings;

    @MockBean
    private UserService userService;

    @MockBean
    private UserTask userTask;

    @Autowired
    private MockMvc mockMvc;
/*
    @Autowired
    private ServerProperties serverProperties;
*/
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

        //int port = serverProperties.getPort();

        mockMvc.perform(get("http://localhost:" + 8080 + "/user/data")
                        .content("")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("Name1"));


    }

/*
    @Test
    public void initTest() {

    }
 */
}
