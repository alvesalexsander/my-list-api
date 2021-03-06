package com.alexsanderalves.mylist.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexsanderalves.mylist.api.models.User;
import com.alexsanderalves.mylist.api.services.IUsersService;
import com.alexsanderalves.mylist.api.utils.DateUtils;

@RestController
public class UserController {
	
	@Autowired
	private IUsersService usersService;

	@GetMapping("/users/{name}")
	public Optional<User> getUserByName(@PathVariable(required=false) String name) {
		var resultado = usersService.findById(name);
		System.out.println(resultado);
		System.out.println(name);
		return resultado;
	}
	
	@PostMapping("/users/get")
	public User getUser(@RequestBody User user) {
		return this.usersService.findUser(user);
	}
	
	@PostMapping("/users/create")
	public User createUser(@RequestBody User user) {
		user.setCreatedAt(DateUtils.getLongNow());
		return this.usersService.create(user);
	}
	
}
