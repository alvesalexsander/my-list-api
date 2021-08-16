package com.alexsanderalves.mylist.api.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexsanderalves.mylist.api.models.TodoListItem;
import com.alexsanderalves.mylist.api.repositories.TodoListItemsRepository;
import com.alexsanderalves.mylist.api.utils.DateUtils;

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
		todoListRepository.setCompletion(itemId, status, DateUtils.getLongNow());
	}

	@Override
	public TodoListItem saveTodoListItem(TodoListItem listItem) {
		return todoListRepository.save(listItem);
	}
	
	@Override
	public void deleteTodoListItem(String itemId) {
		todoListRepository.deleteById(itemId);
	}

}
