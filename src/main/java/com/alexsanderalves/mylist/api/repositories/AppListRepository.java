package com.alexsanderalves.mylist.api.repositories;

import com.alexsanderalves.mylist.api.models.AppList;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppListRepository extends CrudRepository<AppList, String> {
	
	public ArrayList<AppList> findAllByBelongsToUser(String userName);
	
}
