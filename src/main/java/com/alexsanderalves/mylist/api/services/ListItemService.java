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
	public Optional<ListItem> findById(String id, String itemType) {
		CrudRepository<ListItem, String> repository = getRepositoryByModelName(itemType);
		return repository.findById(id);
	}

	@Override
	public ArrayList<ListItem> findListItems(String listType, String listId) {
		Object repository = getRepositoryByListType(listType);
		return (ArrayList) ((TodoListItemsRepository) repository).findAllByBelongsToList(listId);
	}

	@Override
	public ListItem save(ListItem listItem, String listType) {
		CrudRepository<ListItem, String> repository = getRepositoryByListType(listType);
		return repository.save(listItem);
	}
	
	@Override
	public void delete(ListItem listItem, String listType) {
		CrudRepository<ListItem, String> repository = getRepositoryByListType(listType);
		repository.delete(listItem);
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
