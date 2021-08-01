package com.alexsanderalves.mylist.api.repositories;

import com.alexsanderalves.mylist.api.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, String> { }
