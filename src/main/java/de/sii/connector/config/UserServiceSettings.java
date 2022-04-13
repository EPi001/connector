package de.sii.connector.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="user.service")
@Component
public class UserServiceSettings {

    private String url;
    private int userSize;
    private int period;

}