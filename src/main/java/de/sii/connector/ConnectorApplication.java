package de.sii.connector;

import de.sii.connector.user.models.User;
import de.sii.connector.user.repositories.H2Repository;
import de.sii.connector.user.services.UserService;
import de.sii.connector.user.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class ConnectorApplication {

	public static final Duration DEFAULT_READ_TIMEOUT = Duration.ofSeconds(20);
	public static final Duration DEFAULT_CONNECT_TIMEOUT = Duration.ofSeconds(20);

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ConnectorApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return restTemplateBuilder
				.requestFactory(HttpComponentsClientHttpRequestFactory.class)
				.setReadTimeout(DEFAULT_READ_TIMEOUT)
				.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
				.build();
	}

	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver() {
		SpringResourceTemplateResolver templateResolver
				= new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/src/main/resources/templates/user");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		return templateResolver;
	}
}
