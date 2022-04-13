package de.sii.connector.user.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    @JsonProperty("street")
    private Object street;

    @JsonProperty("city")
    private Object city;

    @JsonProperty("state")
    private Object state;

    @JsonProperty("postcode")
    private Object postcode;

}
