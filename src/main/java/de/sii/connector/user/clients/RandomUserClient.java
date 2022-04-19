package de.sii.connector.user.clients;

import de.sii.connector.user.models.UserResults;

import java.util.List;

public interface RandomUserClient {

    List<UserResults> getUsers();

}
