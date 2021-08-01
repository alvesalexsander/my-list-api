package com.alexsanderalves.mylist.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "lists")
public class AppList {
	
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	private String name;
    private String type;
    private String belongsToUser;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "{ id: " + this.getId() + ", name: " + this.getName() + ", type: " + this.getType() + ", belongsToUser: " + this.getBelongsToUser() + " }";
    }

	public String getBelongsToUser() {
		return belongsToUser;
	}

	public void setBelongsToUser(String belongsToUser) {
		this.belongsToUser = belongsToUser;
	}
}