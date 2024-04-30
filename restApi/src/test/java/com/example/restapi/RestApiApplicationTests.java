package com.example.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.ArrayList;

@SpringBootTest
class RestApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void simpleTest() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		assert (myList.get(0) == 1);

		myList.remove(0);
		assert (myList.isEmpty());
	}
}
