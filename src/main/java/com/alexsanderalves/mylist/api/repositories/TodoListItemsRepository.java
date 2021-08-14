package com.alexsanderalves.mylist.api.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alexsanderalves.mylist.api.models.TodoListItem;

@Repository
public interface TodoListItemsRepository extends CrudRepository<TodoListItem, String> {

	public ArrayList<TodoListItem> findAllByBelongsToList(String listId);
	
	@Modifying
	@Transactional
	@Query("update TodoListItem set completed = :status where id = :id")
	public void setCompletion(@Param(value = "id") String id, @Param(value = "status") boolean status);
	 
}
