package de.sii.connector.user.services;

import de.sii.connector.user.clients.RandomUserClient;
import de.sii.connector.user.models.RandomUserResult;
import de.sii.connector.user.models.User;
import de.sii.connector.user.models.UserResults;
import de.sii.connector.user.repositories.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private H2Repository h2Repository;

    @Autowired
    private RandomUserClient randomUserClient;

    @Override
    public List<User> getUsersFromApi() {
        List<User> userList = new ArrayList<>();

        List<UserResults> userResultsList = randomUserClient.getUsers();

        userResultsList.forEach(userResults -> {
            User user = new User();

            user.setName(userResults.getName().toString());
            user.setEmail(userResults.getEmail());
            user.setGender(userResults.getGender());
            user.setLocation(userResults.getLocation().toString());

            userList.add(user);
        });

        return userList;
    }

    public List<User> getUsersFromRepository() {
        List<User> userList = new ArrayList<>();

        Map<String, Object> users = h2Repository.findAllUsers();

        for (String k : users.keySet()) {
            User user = new User();
 //           user.setLocation(users.get(k).);
 //           user.setEmail();
 //           user.setName();
 //           user.setGender();

            userList.add(user);
        }

        return userList;
    }

    public void createUsers(List<User> userList) {
        userList.forEach( user -> {
            h2Repository.createUser(user);
        });

    }
}
