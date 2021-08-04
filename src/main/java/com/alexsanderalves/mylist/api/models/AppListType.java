package com.alexsanderalves.mylist.api.models;

public enum AppListType {
	
	TODO("todo"),
	SHOPPING("shopping");
	
	private String type;
	
	AppListType(String type) {
		this.type = type;
	}
	
	String getType() {
		return this.type;
	}

}