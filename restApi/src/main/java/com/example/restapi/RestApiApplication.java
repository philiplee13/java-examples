package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapi.service.UserService;
import java.util.List;
import com.example.restapi.domain.User;
import com.example.restapi.exceptions.GenericResponseModel;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@RestController
public class RestApiApplication {

	private UserService userService;

	@Autowired
	public RestApiApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	@GetMapping("/users")
	public ResponseEntity<GenericResponseModel> getUsers() {
		List<User> allUsers = userService.getUsers();
		if (allUsers.size() > 0) {
			GenericResponseModel successResponse = new GenericResponseModel(
					allUsers, "Found Users");
			return new ResponseEntity<GenericResponseModel>(successResponse, HttpStatus.OK);
		}

		GenericResponseModel errorResponse = new GenericResponseModel(allUsers, "No users were found...");
		return new ResponseEntity<GenericResponseModel>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{email}")
	public ResponseEntity<GenericResponseModel> getSingleUser(@PathVariable String email) {
		List<User> user = userService.getSingleUser(email);
		if (user.size() > 0) {
			GenericResponseModel successResponse = new GenericResponseModel(user, "Found Individual User");
			return new ResponseEntity<GenericResponseModel>(successResponse, HttpStatus.OK);
		}

		GenericResponseModel errorResponseModel = new GenericResponseModel(user, "Did not find user...");
		return new ResponseEntity<GenericResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}

}

/*
 * to do
 * rest api - get by email - done
 * custom response and exception models - done
 * cud
 * mocking and testing
 * pagination
 */
