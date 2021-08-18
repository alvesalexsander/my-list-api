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
	@Query("update TodoListItem set completed = :status, completion_date = :dateTime where id = :id")
	public void setCompletion(@Param(value = "id") String id, 
			@Param(value = "status") boolean status,
			@Param(value = "dateTime") long dateTime);
	
	@Modifying
	@Transactional
	@Query("update TodoListItem set startline = :startline where id = :id")
	public void setStartline(@Param(value = "id") String id,
			@Param(value = "startline") long startline);
	
	@Modifying
	@Transactional
	@Query("update TodoListItem set deadline = :deadline where id = :id")
	public void setDeadline(@Param(value = "id") String id,
			@Param(value = "deadline") long deadline);
	
	@Modifying
	@Transactional
	@Query("update TodoListItem set list_placement = :listPlacement where id = :id")
	public void setOrder(@Param(value = "id") String id,
			@Param(value = "listPlacement") int listPlacement);
	 
}
