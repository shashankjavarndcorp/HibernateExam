package com.hibernate.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "language_detail")
public class Language {
	
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Language(int id, Country country, String languageName) {
		super();
		this.id = id;
		this.country = country;
		this.languageName = languageName;
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

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade=CascadeType.ALL, mappedBy="language")
	private Country country;
	
	private String languageName;
}
