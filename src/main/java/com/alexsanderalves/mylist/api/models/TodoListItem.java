package com.alexsanderalves.mylist.api.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="todo_items")
public class TodoListItem implements ViewEntity {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	private String name;
	private String belongsToList;
	private int listPlacement;
	private boolean completed = false;
	private long completionDate;
	private long createdAt;
	private long startline;
	private long deadline;
	private String annotations = "";
	private String labels;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDeadline() {
		return deadline;
	}


	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}


	public boolean isCompleted() {
		return completed;
	}


	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String getBelongsToList() {
		return belongsToList;
	}

	public void setBelongsToList(String belongsToList) {
		this.belongsToList = belongsToList;
	}

	public long getCompletion_date() {
		return completionDate;
	}

	public void setCompletion_date(long completion_date) {
		this.completionDate = completion_date;
	}

	@Override
	public String getViewText() {
		return getName();
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public long getStartline() {
		return startline;
	}

	public void setStartline(long startline) {
		this.startline = startline;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getAnnotations() {
		return annotations;
	}

	public void getAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public int getListPlacement() {
		return listPlacement;
	}

	public void setListPlacement(int listPlacement) {
		this.listPlacement = listPlacement;
	}
	
}
