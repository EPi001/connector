package de.sii.connector.user.clients;

import de.sii.connector.config.UserServiceSettings;
import de.sii.connector.user.models.RandomUserResult;
import de.sii.connector.user.models.UserResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RandomUserClientImpl implements RandomUserClient {

    @Autowired
    private UserServiceSettings userServiceSettings;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UserResults> getUsers() {

        URI uri = null;

        try {
            uri = new URI(userServiceSettings.getUrl());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Map<String, String> params = new HashMap<>();

        params.put("results", String.valueOf(userServiceSettings.getUserSize()));

        ResponseEntity<RandomUserResult> responseEntity = restTemplate.getForEntity(uri.toString() + "?results={results}", RandomUserResult.class, params);

        System.out.println("retrieved " + responseEntity.getBody().getResults().size() + " items");

        return responseEntity.getBody().getResults();

    }
}
