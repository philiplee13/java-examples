package com.example.restapi.service;

import com.example.restapi.dao.UserDaoImpl;
import com.example.restapi.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserService(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public List<User> getUsers() {
        return userDaoImpl.getAllUsers();
    }

    public List<User> getSingleUser(String email) {
        return userDaoImpl.getSingleUser(email);
    }

    public Integer createUser(User user) {
        return userDaoImpl.createUser(user);
    }

    public Integer deleteUser(String email) {
        return userDaoImpl.deleteUser(email);
    }
}
