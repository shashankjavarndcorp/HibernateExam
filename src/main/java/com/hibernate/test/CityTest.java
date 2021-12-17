package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.models.City;

public class CityTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		City city = new City();
		city.setName("Jakarta");
		session.save(city);
		session.getTransaction().commit();
	}

}
