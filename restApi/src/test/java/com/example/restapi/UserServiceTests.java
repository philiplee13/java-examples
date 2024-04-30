package com.example.restapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.restapi.domain.User;
import com.example.restapi.service.UserService;
import java.util.List;
import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
public class UserServiceTests {

    @Autowired
    UserService userService;

    // test user GET service - uses H2
    @Test
    void testUserGetService() {
        // setup
        User user = new User("testFirstName", "testLastName", "testEmail@email.com");
        List<User> expectedResult = new ArrayList<User>();
        expectedResult.add(user);

        // run method
        List<User> getUserResult = userService.getSingleUser("testEmail@email.com");

        // assert
        assertEquals(expectedResult.get(0).firstName, getUserResult.get(0).firstName);
        assertEquals(expectedResult.get(0).lastName, getUserResult.get(0).lastName);
        assertEquals(expectedResult.get(0).email, getUserResult.get(0).email);
    }

    // test user CREATE service
    @Test
    void testUserCreateService() {

        User userToInsert = new User("insertUserFirstName", "insertUserLastName", "insertUser@email.com");
        Integer expectedResult = 1;
        Integer result = userService.createUser(userToInsert);

        assertEquals(expectedResult, result);
    }

    // test user DELETE service
    @Test
    void testUserDeleteService() {
        String userEmailToDelete = "testEmail@email.com";

        Integer expectedResult = 1;

        Integer result = userService.deleteUser(userEmailToDelete);

        assertEquals(expectedResult, result);
    }
}
