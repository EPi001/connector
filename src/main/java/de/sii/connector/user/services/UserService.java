package de.sii.connector.user.services;

import de.sii.connector.user.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsersFromApi();

    List<User> getUsersFromRepository();

    void createUsers(List<User> userList);
}
