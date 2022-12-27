package com.california.hotel.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String location;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel", orphanRemoval = true)
	private Set<Room> books = new HashSet<>();

	public Hotel() {

	}

	public Hotel(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public void addRoom(Room room) {
		
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

	public Set<Room> getBooks() {
		return books;
	}

	public void setBooks(Set<Room> books) {
		this.books = books;
	}
}