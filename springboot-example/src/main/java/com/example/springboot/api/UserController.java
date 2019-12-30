package com.example.springboot.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.util.LoggerUtil;

@RestController
@RequestMapping("/api")
public class UserController {
	protected static Logger logger = Logger.getLogger(UserController.class);
	private static final String FLOW_NAME = "UserFlow";

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public User create(@RequestBody User user) {
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.START, user.getId(), user.getId(), LoggerUtil.ADD_UPDATE);
		User createdUser = userRepository.save(user);
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.END, user.getId(), user.getId(), LoggerUtil.ADD_UPDATE);
		return createdUser;
	}

	@GetMapping("/users")
	public List<User> findAll() {
		logger.debug("Called findAll");
		return userRepository.findAll();
	}

	@PutMapping("/users/{user_id}")
	public User update(@PathVariable("user_id") Long userId, @RequestBody User userObject) {
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.START, userId, userId, LoggerUtil.ADD_UPDATE);
		User user = userRepository.getOne(userId);
		user.setName(userObject.getName());
		user.setCountry(userObject.getCountry());
		User updatedUser = userRepository.save(user);
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.END, user.getId(), user.getId(), LoggerUtil.ADD_UPDATE);
		return updatedUser;
	}

	@DeleteMapping("/users/{user_id}")
	public List<User> delete(@PathVariable("user_id") Long userId) {
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.START, userId, userId, LoggerUtil.DELETE);
		List<User> users = userRepository.findAll();
		LoggerUtil.pushLog(logger, FLOW_NAME, LoggerUtil.END, userId, userId, LoggerUtil.DELETE);
		return users;
	}

	@GetMapping("/users/{user_id}")
	@ResponseBody
	public User findByUserId(@PathVariable("user_id") Long userId) {
		logger.debug("Called findByUserId");
		return userRepository.getOne(userId);
	}
}