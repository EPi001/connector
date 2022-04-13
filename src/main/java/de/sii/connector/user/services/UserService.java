package de.sii.connector.user.services;

import de.sii.connector.user.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getUsers();
}
