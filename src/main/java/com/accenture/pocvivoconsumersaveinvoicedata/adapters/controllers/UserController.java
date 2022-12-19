package com.accenture.pocvivoconsumersaveinvoicedata.adapters.controllers;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.UserDto;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.User;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.repositories.UserDAL;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final UserRepository userRepository;
	private final UserDAL userDAL;

	public UserController(UserRepository userRepository, UserDAL userDAL) {
		this.userRepository = userRepository;
		this.userDAL = userDAL;
	}

	@PostMapping("/create")
	public User addNewUsers(@RequestBody UserDto user) {
		LOG.info("Saving user.");
		User newUser = new User(user.getUserId(), user.getName(), user.getCreationDate(), user.getUserSettings());
		return userRepository.save(newUser);
	}

	@GetMapping("")
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userDAL.getUserById(userId);
	}

	// @RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	// public Object getAllUserSettings(@PathVariable String userId) {
	// User user = userRepository.findOne(userId);
	// if (user != null) {
	// return user.getUserSettings();
	// } else {
	// return "User not found.";
	// }
	// }

	@GetMapping("/settings/{userId}")
	public Object getAllUserSettings(@PathVariable String userId) {
		User user = userDAL.getUserById(userId);
		if (user != null) {
			return userDAL.getAllUserSettings(userId);
		} else {
			return "User not found.";
		}
	}

	@GetMapping("/settings/{userId}/{key}")
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		return userDAL.getUserSetting(userId, key);
	}

	@GetMapping("/settings/{userId}/{key}/{value}")
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		User user = userDAL.getUserById(userId);
		if (user != null) {
			user.getUserSettings().put(key, value);
			userRepository.save(user);
			return "Key added";
		} else {
			return "User not found.";
		}
	}
}