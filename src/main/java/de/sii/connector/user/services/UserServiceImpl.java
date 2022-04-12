package de.sii.connector.user.services;

import de.sii.connector.user.models.UserEntity;
import de.sii.connector.user.repositories.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private H2Repository h2Repository;

    @Override
    public List<UserEntity> getUsers() {
        return null;
    }
}
