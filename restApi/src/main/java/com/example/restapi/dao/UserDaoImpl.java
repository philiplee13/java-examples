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

    public Integer getCountOfAllRows() {
        String sql = "SELECT COUNT(*) from test.users;";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<User> getAllUsers(String size, String page) {
        Integer intPageSize = Integer.parseInt(size);
        Integer intPageNumber = Integer.parseInt(page);
        String sql = "SELECT * FROM test.users order by email limit ? offset ?";
        return jdbcTemplate.query(sql, userRowMapper, intPageSize, intPageNumber);
    }

    public List<User> getSingleUser(String email) {
        String sql = "SELECT * FROM test.users where email = ?";
        return jdbcTemplate.query(sql, userRowMapper, email);
    }

    public Integer createUser(User user) {
        String sql = "INSERT INTO test.users (first_name, last_name, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.firstName, user.lastName, user.email);
    }

    public Integer deleteUser(String email) {
        String sql = "DELETE FROM test.users WHERE email = ?";
        return jdbcTemplate.update(sql, email);
    }

    public Integer updateUser(User user) {
        String sql = "UPDATE test.users SET first_name = ?, last_name = ? WHERE email = ?";
        return jdbcTemplate.update(sql, user.firstName, user.lastName, user.email);
    }

}