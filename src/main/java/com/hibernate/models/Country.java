package com.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Set;

@Entity(name = "country_detail")
public class Country {
	


	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String name, Language language, City capital, Set<Sports> sports) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.capital = capital;
		this.sports = sports;
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

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public Set<Sports> getSports() {
		return sports;
	}

	public void setSports(Set<Sports> sports) {
		this.sports = sports;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "language_detail_id")
	private Language language;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "city_detail_id")
	private City capital;
	
	@ManyToMany(targetEntity = Sports.class, cascade = { javax.persistence.CascadeType.ALL })
	@JoinTable(name = "COUNTRY_SPORTS",joinColumns = { @JoinColumn(name = "country_id") }, inverseJoinColumns = { @JoinColumn(name = "sports_id")})
	private Set<Sports> sports;
}
