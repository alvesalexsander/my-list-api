package com.alexsanderalves.mylist.api.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexsanderalves.mylist.api.models.TodoListItem;

@Repository
public interface TodoListItemsRepository extends CrudRepository<TodoListItem, String> {

	public ArrayList<TodoListItem> findAllByBelongsToList(String listId);
	
}
