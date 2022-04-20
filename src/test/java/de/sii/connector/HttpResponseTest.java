package de.sii.connector;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpResponseTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldPassOnMatchingContentInResponse() {
        String result = restTemplate.getForObject("http://localhost:" + port + "/user", String.class);
        assertThat(String.valueOf(result), StringContains.containsString("Location"));
    }
}
