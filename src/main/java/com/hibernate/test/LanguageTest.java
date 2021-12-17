package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.models.Language;

public class LanguageTest {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Language lang = new Language();
		lang.setLanguageName("Hindi");
		session.save(lang);
		session.getTransaction().commit();
	}

}
