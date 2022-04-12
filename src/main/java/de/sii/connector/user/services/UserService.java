package de.sii.connector.user.services;

import de.sii.connector.user.models.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();
}
