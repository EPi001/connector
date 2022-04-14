package de.sii.connector.user.repositories;

import de.sii.connector.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class H2Repository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> findAllUsers() {
        String sql = "SELECT * FROM users ORDER BY id DESC";

        return jdbcTemplate.queryForMap(sql);
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
