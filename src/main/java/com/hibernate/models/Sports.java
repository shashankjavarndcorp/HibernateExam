package com.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.Set;

@Entity(name = "sport_detail")
public class Sports {
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sports(int id, Set<Country> countries, String sportName) {
		super();
		this.id = id;
		this.countries = countries;
		this.sportName = sportName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy = "sports")
	private Set<Country> countries;
	
	private String sportName;

}
