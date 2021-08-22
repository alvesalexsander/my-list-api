package com.alexsanderalves.mylist.api.services;

import java.util.ArrayList;
import java.util.Optional;

import com.alexsanderalves.mylist.api.models.AppList;

public interface IAppListService {

	public ArrayList<AppList> findAll();
	public Optional<AppList> findById(String id);
	public ArrayList<AppList> findAllByBelongsToUser(String userName);
	public AppList save(AppList list);
	public void deleteList(String listId);
	
}
