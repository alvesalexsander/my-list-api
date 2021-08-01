package com.alexsanderalves.mylist.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "name", updatable = false, nullable = false)
	private String name;
	private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "{ name: " + this.getName() + " }";
    }

}
