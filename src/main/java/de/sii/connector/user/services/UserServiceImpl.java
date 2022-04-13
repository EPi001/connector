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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private H2Repository h2Repository;

    @Autowired
    private RandomUserClient randomUserClient;

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        List<UserResults> userResultsList = randomUserClient.getUsers();

        userResultsList.forEach(x -> {
            User user = new User();

            user.setName(x.getName().toString());
            user.setEmail(x.getEmail());
            user.setGender(x.getGender());
            user.setLocation(x.getLocation().toString());

            userList.add(user);
        });

        return userList;
    }
}
