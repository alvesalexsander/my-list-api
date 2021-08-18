package com.alexsanderalves.mylist.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexsanderalves.mylist.api.models.TodoListItem;
import com.alexsanderalves.mylist.api.services.ListItemService;
import com.alexsanderalves.mylist.api.utils.DateUtils;

@RestController
public class ListItemController {
	
	@Autowired
	private ListItemService listItemService;
	
	@GetMapping("/list-item/todo/{listId}")
	public ArrayList<TodoListItem> findTodoItemsByList(@PathVariable(required=true) String listId) {
		return listItemService.findTodoListItems(listId);
	}
	
	@PostMapping("/list-item/todo/create")
	public TodoListItem createList(@RequestBody TodoListItem list) {
		list.setCreatedAt(DateUtils.getLongNow());
		return listItemService.saveTodoListItem(list);
	}
	
	@PostMapping("/list-item/todo/complete/{itemId}/{status}")
	public void setCompletion(@PathVariable(required=true) String itemId, @PathVariable(required=true) boolean status) {
		listItemService.setCompletion(itemId, status);
	}
	
	@DeleteMapping("/list-item/todo/delete/{itemId}")
	public boolean deleteListItem(@PathVariable(required=true) String itemId) {
		System.out.println(itemId);
		try{
			listItemService.deleteTodoListItem(itemId);
			return true;
		} catch (Exception error) {
			System.out.println(itemId);
			return false;
		}
	}
	
}
