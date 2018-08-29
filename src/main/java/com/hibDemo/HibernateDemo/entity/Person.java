package com.hibDemo.HibernateDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity // this maps to the table
//@Table(name="person") - can use this if your table name doesn't match your pojo

// this is like saying SELECT * FROM person
@NamedQuery(name="find_all_persons", query = "Select p FROM Person p")
public class Person {
	
	@Id // this for a primary key & you always need a primary key for hibernate
	@GeneratedValue(strategy=GenerationType.IDENTITY) // allows primary key to be auto generated
	// strategy type above allows us to let mySql 
	private int id;
	
	//  @Column(name="name") --> can use this if our column names don't match teh variable names.
	private String name;
	private String location;
	
	// always add a no argument constructor
	public Person() {
		
	}

	public Person(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	
	// this constructor is for adding a user
	// we don't need to take in an id because
	// hiberate/mySql will manage that for us.
	public Person(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", location=" + location;
	}
}
