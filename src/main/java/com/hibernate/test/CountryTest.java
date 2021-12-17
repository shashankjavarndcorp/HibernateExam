package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.models.Country;

public class CountryTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Country country = new Country();
		country.setName("Israile");
		session.save(country);
		session.getTransaction().commit();
		session.close();
	}

}
