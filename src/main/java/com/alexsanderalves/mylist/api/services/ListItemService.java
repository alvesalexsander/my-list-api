package com.alexsanderalves.mylist.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.alexsanderalves.mylist.api.models.AppList;
import com.alexsanderalves.mylist.api.models.ListItem;
import com.alexsanderalves.mylist.api.models.TodoListItem;
import com.alexsanderalves.mylist.api.repositories.TodoListItemsRepository;

@Service
public class ListItemService implements IListItemService {
	
	@Autowired
	private TodoListItemsRepository todoListRepository;

	@Override
	public Optional<TodoListItem> findTodoListItemById(String id) {
		return todoListRepository.findById(id);
	}

	@Override
	public ArrayList<TodoListItem> findTodoListItems(String listId) {
		return todoListRepository.findAllByBelongsToList(listId);
	}
	
	@Override
	public void setCompletion(String itemId, boolean status) {
		todoListRepository.setCompletion(itemId, status);
	}

	@Override
	public TodoListItem saveTodoListItem(TodoListItem listItem) {
		return todoListRepository.save(listItem);
	}
	
	@Override
	public void deleteTodoListItem(TodoListItem listItem) {
		todoListRepository.delete(listItem);
	}

	private CrudRepository<ListItem, String> getRepositoryByModelName(String itemType) {
		if (itemType == "TodoListItem") {
			return (CrudRepository) todoListRepository;
		}
		return null;
	}
	
	private CrudRepository<ListItem, String> getRepositoryByListType(String listType) {
		if (listType == "todo") {
			return (CrudRepository) todoListRepository;
		}
		return null;
	}
	
	private CrudRepository<ListItem, String> getRepositoryByModel(ListItem listItem) {
		if (listItem instanceof TodoListItem) {
			return (CrudRepository) todoListRepository;
		}
		return null;
	}

}
