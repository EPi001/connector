package de.sii.connector;

import de.sii.connector.user.clients.RandomUserClient;
import de.sii.connector.user.models.Location;
import de.sii.connector.user.models.Name;
import de.sii.connector.user.models.User;
import de.sii.connector.user.models.UserResults;
import de.sii.connector.user.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTests {

    @MockBean
    RandomUserClient randomUserClient;

    @Autowired
    UserService userService;

    @Test
    public void getUsersFromApiTest() {
        List<UserResults> userResultsList = new ArrayList<>();

        UserResults userResults1 = new UserResults();
        Location location1 = new Location();
        Name name1 = new Name();

        location1.setCity("city1");
        location1.setPostcode("postcode1");
        location1.setState("state1");
        location1.setStreet("street1");

        name1.setFirst("first1");
        name1.setLast("last1");
        name1.setTitle("title1");

        userResults1.setLocation(location1);
        userResults1.setName(name1);
        userResults1.setEmail("email1");
        userResults1.setGender("male");

        UserResults userResults2 = new UserResults();
        Location location2 = new Location();
        Name name2 = new Name();

        location2.setCity("city2");
        location2.setPostcode("postcode2");
        location2.setState("state2");
        location2.setStreet("street2");

        name2.setFirst("first2");
        name2.setLast("last2");
        name2.setTitle("title2");

        userResults2.setLocation(location2);
        userResults2.setName(name2);
        userResults2.setEmail("email2");
        userResults2.setGender("female");

        userResultsList.add(userResults1);
        userResultsList.add(userResults2);

        when(randomUserClient.getUsers()).thenReturn(userResultsList);

        List<User> userList = userService.getUsersFromApi();

        assertNotNull(userList);
        assertNotNull(userList.get(0));
        assertNotNull(userList.get(1));

        User user1 = userList.get(0);
        User user2 = userList.get(1);

        assertNotNull(user1);
        assertNotNull(user2);

        assertEquals("email1", user1.getEmail(), () -> "expected email1");
        assertEquals("email2", user2.getEmail(), () -> "expected email2");
        assertTrue(user1.getLocation().contains("city1"), () -> "location should contain city1");
        assertTrue(user2.getLocation().contains("city2"), () -> "location should contain city2");

    }
/*
    @Test
    public void getUsersFromRepositoryTest() {

    }

    @Test
    public void createUsersTest(List<User> userList) {

    }
 */
}
