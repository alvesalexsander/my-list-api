package com.alexsanderalves.mylist.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexsanderalves.mylist.api.models.User;
import com.alexsanderalves.mylist.api.repositories.UsersRepository;

@Service
public class UsersService implements IUsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> foundUser = this.usersRepository.findById(user.getName());
		if (foundUser.isPresent()) {
			System.out.println("RETORNANDO USER EXISTENTE");
			return foundUser.get();
		} else {
			System.out.println("RETORNANDO NOVO USER");
			return this.usersRepository.save(user);
		}
	}
	
	@Override
	public Optional<User> findById(String id) {
		return usersRepository.findById(id);
	}
	
	@Override
	public User save(User list) {
		return usersRepository.save(list);
	}

}
