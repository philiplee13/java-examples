/*
 * This file needs to implement the interface from trhe UserDao.java
 * It needs to implement all the methods specifed there
 */

package com.example.restapi.dao;

import com.example.restapi.domain.User;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private UserRowMapper userRowMapper = new UserRowMapper(); // so this works - but is a little inconsistent
    // should these two be in a constructor?

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM test.users;";
        return jdbcTemplate.query(sql, userRowMapper);
    }

    public List<User> getSingleUser(String email) {
        String sql = "SELECT * FROM test.users where email = ?";
        return jdbcTemplate.query(sql, userRowMapper, email);
    }

}