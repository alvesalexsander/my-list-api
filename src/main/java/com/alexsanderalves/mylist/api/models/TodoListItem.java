package com.alexsanderalves.mylist.api.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="todo-items")
public class TodoListItem extends ListItem implements ViewEntity {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	private boolean completed = false;
	private LocalDateTime deadline;
	private String belongsToList;
	
	@Override
	public String getViewText() {
		return getName();
	}


	public LocalDateTime getDeadline() {
		return deadline;
	}


	public void setDeadline(LocalDateTime deadline) {
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

}
