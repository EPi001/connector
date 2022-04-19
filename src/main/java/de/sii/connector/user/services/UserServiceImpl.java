package de.sii.connector.user.services;

import de.sii.connector.user.clients.RandomUserClient;
import de.sii.connector.user.models.User;
import de.sii.connector.user.models.UserResults;
import de.sii.connector.user.repositories.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return h2Repository.findAllUsers();
    }

    public void createUsers(List<User> userList) {
        userList.forEach( user -> {
            h2Repository.createUser(user);
        });

    }
}
