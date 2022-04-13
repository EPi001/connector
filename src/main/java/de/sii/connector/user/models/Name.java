package de.sii.connector.user.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {

    @JsonProperty("title")
    private Object title;

    @JsonProperty("first")
    private Object first;

    @JsonProperty("last")
    private Object last;

}
