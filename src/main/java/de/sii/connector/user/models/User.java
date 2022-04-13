package de.sii.connector.user.models;

import lombok.Data;

@Data
public class User
{
    private int id;
    private String gender;
    private String name;
    private String location;
    private String email;

}
