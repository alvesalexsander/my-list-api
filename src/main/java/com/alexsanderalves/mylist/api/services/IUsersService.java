package com.alexsanderalves.mylist.api.services;

import java.util.Optional;

import com.alexsanderalves.mylist.api.models.User;

public interface IUsersService {

	public User findUser(User user);
	public Optional<User> findById(String id);
	public User create(User user);
	
}
