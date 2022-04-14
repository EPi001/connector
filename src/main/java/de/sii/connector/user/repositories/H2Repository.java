package de.sii.connector.user.repositories;

import de.sii.connector.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class H2Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM users ORDER BY id DESC";

        List<Map<String, Object>> userMapList = jdbcTemplate.queryForList(sql);

        userMapList.stream().forEach(map -> {
            User user = new User();
            user.setGender(map.get("gender").toString());
            user.setEmail(map.get("email").toString());
            user.setLocation(map.get("location").toString());
            user.setName(map.get("name").toString());
            user.setId(Integer.valueOf(map.get("id").toString()));

            userList.add(user);
        });

        return userList;
    }

    public void createUser(User user) {

        String gender = user.getGender();
        String name = user.getName();
        String location = user.getLocation();
        String email = user.getEmail();

        String sql = "INSERT INTO users (gender, name, location, email) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, gender, name, location, email);
    }

}
