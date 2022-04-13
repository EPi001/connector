package de.sii.connector.user.clients;

import de.sii.connector.config.UserServiceSettings;
import org.springframework.beans.factory.annotation.Autowired;

public interface RandomUserClient {

    String getUsers();

}
