package de.sii.connector;

import de.sii.connector.user.models.User;
import de.sii.connector.user.repositories.H2Repository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class H2RepositoryTests {

    @Autowired
    H2Repository h2Repository;

    @Test
    @Order(1)
    public void createUserTest() {

        /* No errors expected. */
        assertDoesNotThrow(() -> {
            User user1 = new User();

            user1.setGender("gender1");
            user1.setName("name1");
            user1.setLocation("location1");
            user1.setEmail("email1");

            h2Repository.createUser(user1);
        });

        /* No errors expected. */
        assertDoesNotThrow(() -> {
            User user2 = new User();

            user2.setGender("gender2");
            user2.setName("name2");
            user2.setLocation("location2");
            user2.setEmail("email2");

            h2Repository.createUser(user2);
        });
    }

    @Test
    @Order(2)
    public void findAllUsersTest() {
        List<User> users = h2Repository.findAllUsers();

        assertNotNull(users, () -> "List must not be null");
        assertEquals(Math.min(users.size(), 2), 2, () -> "List has at least two entries");
    }
}
