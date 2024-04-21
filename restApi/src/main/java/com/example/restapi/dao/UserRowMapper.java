package com.example.restapi.dao;

import com.example.restapi.domain.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Override;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNumber) throws SQLException {
        User user = new User(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"));
        return user;
    }
}
