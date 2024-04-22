/*
 * This file will be the interface for the UserDao
 * This should hold all the methods we need to implement
 * So for example we might want 
 *  to get all users
 *  to get an individual user
 *  etc
 */

package com.example.restapi.dao;

import java.util.List;
import com.example.restapi.domain.User;

public interface UserDao {

    // GET
    // method to get all users
    List<User> getAllUsers();

    // method to get individual user based on email
    List<User> getSingleUser(String email);

    // CREATE
    Integer createUser(User user);

    // UPDATE
    Integer updateUser(User user);

    // DELETE
    Integer deleteUser(String email);
}
