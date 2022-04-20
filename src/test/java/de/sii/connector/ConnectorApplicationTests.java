package de.sii.connector;

import de.sii.connector.user.controllers.UserController;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class ConnectorApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		assertThat(userController, is(IsNull.notNullValue()));
	}

}
