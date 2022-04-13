package de.sii.connector.user.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResults {

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("name")
    private Name name;

    @JsonProperty("location")
    private Location location;

    @JsonProperty("email")
    private String email;
}
