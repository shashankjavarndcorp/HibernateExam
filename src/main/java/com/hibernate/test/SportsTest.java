package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.models.Sports;

public class SportsTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("com/hibernate/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Sports sport = new Sports();
		sport.setSportName("BasketBall");
		session.save(sport);
		session.getTransaction().commit();
	}
}
