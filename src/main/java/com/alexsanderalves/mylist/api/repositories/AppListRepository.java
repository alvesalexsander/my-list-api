package com.alexsanderalves.mylist.api.repositories;

import com.alexsanderalves.mylist.api.models.AppList;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AppListRepository extends CrudRepository<AppList, String> {
	
	public ArrayList<AppList> findAllByBelongsToUser(String userName);
	
	@Modifying
	@Transactional
	@Query("update AppList set name = :name where id = :id")
	public void updateById(@Param(value = "id") String id,
			@Param(value = "name") String name);
	
}
