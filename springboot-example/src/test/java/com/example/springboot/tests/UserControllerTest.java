package com.example.springboot.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.api.UserController;
import com.example.springboot.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	@Autowired
	private UserController userController;
	
	@Test
	public void createTest() {
		User user = new User();
		user.setName("Test User");
		user.setCountry("India");
		userController.create(user);
	}
}
