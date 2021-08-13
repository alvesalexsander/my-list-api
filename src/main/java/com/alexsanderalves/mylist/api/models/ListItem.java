package com.alexsanderalves.mylist.api.models;

public abstract class ListItem implements ViewEntity {

	protected String id;
	protected String name;
	protected String belongsToList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBelongsToList() {
		return belongsToList;
	}

	public void setBelongsToList(String belongsToList) {
		this.belongsToList = belongsToList;
	}
	
}
