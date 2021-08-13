package com.alexsanderalves.mylist.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.alexsanderalves.mylist.api.models.AppList;
import com.alexsanderalves.mylist.api.models.ListItem;

public interface IListItemService {

	public Optional<ListItem> findById(String id, String itemType);
	public ArrayList<ListItem> findListItems(String listType, String listId);
	public ListItem save(ListItem listItem, String listType);
	public void delete(ListItem listItem, String listType);
	
}
