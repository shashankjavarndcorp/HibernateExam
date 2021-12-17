package com.hibernate.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import com.hibernate.models.City;
import com.hibernate.models.Country;
import com.hibernate.models.Language;
import com.hibernate.models.Sports;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.*;

public class EditCountryDetails extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Sports> sports = new HashSet<Sports>();;
		int country_id = Integer.parseInt(request.getParameter("id"));
		int language_id = Integer.parseInt(request.getParameter("languages"));
		int city_id = Integer.parseInt(request.getParameter("capitalCity"));
		String[] values = request.getParameterValues("country_sports");
		
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session_country = sessionFactory.openSession();
		
		session_country.beginTransaction();
		Country county = session_country.get(Country.class, country_id);
		Language lang = session_country.get(Language.class, language_id);
		City capital = session_country.get(City.class, city_id);
		
		county.setLanguage(lang);
		county.setCapital(capital);
		
		for(int i=0; i<values.length; i++) {
			Sports sport = session_country.get(Sports.class, Integer.parseInt(values[i]));
			sports.add(sport);
			
		}
		county.setSports(sports);

		session_country.save(county);
		session_country.getTransaction().commit();
		
	}

}
