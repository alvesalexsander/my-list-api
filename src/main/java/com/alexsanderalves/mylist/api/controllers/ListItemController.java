package com.alexsanderalves.mylist.api.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexsanderalves.mylist.api.models.AppList;
import com.alexsanderalves.mylist.api.models.ListItem;
import com.alexsanderalves.mylist.api.services.ListItemService;

@RestController
public class ListItemController {
	
	@Autowired
	private ListItemService listItemService;
	
	@GetMapping("/list-item/{listType}/{listId}")
	public ArrayList<ListItem> findListItemsByList(@PathVariable(required=true) String listType, @PathVariable(required=true) String listId) {
		return listItemService.findListItems(listType, listId);
	}
	
	@PostMapping("/list-item/create")
	public ListItem createList(@RequestBody ListItem list, @PathVariable(required=true) String listType) {
		return listItemService.save(list, listType);
	}
	
	@DeleteMapping("/list-item/{listType}/delete")
	public boolean deleteListItem(@RequestBody ListItem list, @PathVariable(required=true) String listType) {
		try{
			listItemService.delete(list, listType);
			return true;
		} catch (Exception error) {
			return false;
		}
	}
	
}
