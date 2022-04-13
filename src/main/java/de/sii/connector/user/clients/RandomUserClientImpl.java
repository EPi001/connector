package de.sii.connector.user.clients;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.models.RandomUserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class RandomUserClientImpl implements RandomUserClient {

    @Autowired
    private UserServiceSettings userServiceSettings;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getUsers() {

        URI uri = null;

        try {
            uri = new URI(userServiceSettings.getUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        restTemplate.getForObject(uri, RandomUserResult.class);

        return null;
    }
}
