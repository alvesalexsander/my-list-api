package com.alexsanderalves.mylist.api.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexsanderalves.mylist.api.models.AppList;
import com.alexsanderalves.mylist.api.services.IAppListService;
import com.alexsanderalves.mylist.api.utils.DateUtils;

@RestController
public class AppListController {
	
	@Autowired
	private IAppListService listService;
	
	@GetMapping("/lists/{userName}")
	public ArrayList<AppList> findListsByOwner(@PathVariable(required=false) String userName) {
		var resultado = listService.findAllByBelongsToUser(userName);
		System.out.println(resultado);
		System.out.println(userName);
		return resultado;
	}
	
	@PostMapping("/lists/create")
	public AppList createList(@RequestBody AppList list) {
		list.setCreatedAt(DateUtils.getLongNow());
		AppList createdList = listService.save(list);
		System.out.println("Nova Lista criada...");
		System.out.println(createdList);
		return createdList;
	}

	
}
