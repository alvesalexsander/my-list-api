package com.alexsanderalves.mylist.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.alexsanderalves.mylist.api.models.TodoListItem;

public interface IListItemService {

	public Optional<TodoListItem> findTodoListItemById(String id);
	public ArrayList<TodoListItem> findTodoListItems(String listId);
	public void setCompletion(String itemId, boolean status);
	public TodoListItem saveTodoListItem(TodoListItem listItem);
	public void deleteTodoListItem(TodoListItem listItem);
	
}
