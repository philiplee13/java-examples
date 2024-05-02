package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapi.service.UserService;
import java.util.List;

import com.example.restapi.domain.User;
import com.example.restapi.exceptions.GetResponseModel;
import com.example.restapi.exceptions.UpdateResponseModel;
import com.example.restapi.exceptions.GetResponseModelPaginated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.RequestBody;

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
	public ResponseEntity<GetResponseModelPaginated> getUsers(
			@RequestParam(defaultValue = "2") String size,
			@RequestParam(defaultValue = "0") String page) {

		// get total count of users
		Integer totalCount = userService.getCountOfAllUsers();
		// get all users
		List<User> allUsers = userService.getUsers(size, page);

		Integer nextStartingRow = Integer.parseInt(page) + Integer.parseInt(size); // limit + offset
		Boolean isNextPage = nextStartingRow < totalCount; // if our next starting row is < the total size

		if (allUsers.size() > 0) {
			GetResponseModelPaginated paginatedResponse = new GetResponseModelPaginated(allUsers,
					"Found Users using pagination", isNextPage, allUsers.size());
			return new ResponseEntity<GetResponseModelPaginated>(paginatedResponse, HttpStatus.OK);
		}

		GetResponseModelPaginated errorResponse = new GetResponseModelPaginated(allUsers,
				"No users were found during pagination, maybe reached limit", isNextPage, allUsers.size());
		return new ResponseEntity<GetResponseModelPaginated>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/users/{email}")
	public ResponseEntity<GetResponseModel> getSingleUser(@PathVariable String email) {
		List<User> user = userService.getSingleUser(email);
		if (user.size() > 0) {
			GetResponseModel successResponse = new GetResponseModel(user, "Found Individual User");
			return new ResponseEntity<GetResponseModel>(successResponse, HttpStatus.OK);
		}

		GetResponseModel errorResponseModel = new GetResponseModel(user, "Did not find user...");
		return new ResponseEntity<GetResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/users")
	public ResponseEntity<UpdateResponseModel> createUser(@RequestBody User user) {
		Integer createdUser = userService.createUser(user);
		if (createdUser > 0) {
			UpdateResponseModel successfulUpdateResponse = new UpdateResponseModel(createdUser, "Created One User");
			return new ResponseEntity<UpdateResponseModel>(successfulUpdateResponse, HttpStatus.OK);
		}
		UpdateResponseModel errorResponseModel = new UpdateResponseModel(createdUser, "Did not create any user...");
		return new ResponseEntity<UpdateResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/users/{email}")
	public ResponseEntity<UpdateResponseModel> deleteUser(@PathVariable String email) {
		Integer deletedUser = userService.deleteUser(email);
		if (deletedUser > 0) {
			UpdateResponseModel successfulDeleteResponse = new UpdateResponseModel(deletedUser,
					"Successfully deleted user");
			return new ResponseEntity<UpdateResponseModel>(successfulDeleteResponse, HttpStatus.OK);
		}

		UpdateResponseModel errorResponseModel = new UpdateResponseModel(deletedUser, "No users to delete...");
		return new ResponseEntity<UpdateResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/users")
	public ResponseEntity<UpdateResponseModel> updateUser(@RequestBody User user) {
		Integer createdUser = userService.updateUser(user);
		if (createdUser > 0) {
			UpdateResponseModel successfulUpdateResponse = new UpdateResponseModel(createdUser, "Updated One User");
			return new ResponseEntity<UpdateResponseModel>(successfulUpdateResponse, HttpStatus.OK);
		}
		UpdateResponseModel errorResponseModel = new UpdateResponseModel(createdUser, "Did not update any user...");
		return new ResponseEntity<UpdateResponseModel>(errorResponseModel, HttpStatus.NOT_FOUND);
	}
}
