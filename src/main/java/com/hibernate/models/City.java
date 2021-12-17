package com.hibernate.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "city_detail")
public class City {
	
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int id, Country country, String name) {
		super();
		this.id = id;
		this.country = country;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="capital")
	private Country country;
	
	private String name;

}
