package com.alexsanderalves.mylist.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexsanderalves.mylist.api.models.AppList;
import com.alexsanderalves.mylist.api.repositories.AppListRepository;

@Service
public class AppListService implements IAppListService {
	
	@Autowired
	private AppListRepository appListRepository;

	@Override
	public ArrayList<AppList> findAll() {
		return (ArrayList<AppList>) appListRepository.findAll();
	}
	
	@Override
	public Optional<AppList> findById(String id) {
		return appListRepository.findById(id);
	}
	
	@Override
	public AppList save(AppList list) {
		return appListRepository.save(list);
	}

	@Override
	public ArrayList<AppList> findAllByBelongsToUser(String userName) {
		return appListRepository.findAllByBelongsToUser(userName);
	}
	
	@Override
	public void deleteList(String listId) {
		appListRepository.deleteById(listId);
	}
}
