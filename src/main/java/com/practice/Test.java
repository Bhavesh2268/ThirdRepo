package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user1 = new User();
		User user2 = new User();
		
		user1.setName("Walter");
		user1.setEmail("walter@123");
		
		user2.setName("Jesse");
		user2.setEmail("jesse@123");
		
		Nominee nominee1 = new Nominee();
		Nominee nominee2 = new Nominee();
		Nominee nominee3 = new Nominee();
		
		nominee1.setName("Skyler");
		nominee2.setName("Jane");
		nominee3.setName("Marry");
		
		user1.getNomineeList().add(nominee1);
		user1.getNomineeList().add(nominee2);
		user1.getNomineeList().add(nominee3);
		
		nominee1.getUserList().add(user1);
		nominee2.getUserList().add(user1);
		nominee3.getUserList().add(user1);
		
		user2.getNomineeList().add(nominee2);
		user2.getNomineeList().add(nominee3);
		
		nominee2.getUserList().add(user2);
		nominee3.getUserList().add(user2);
		
		session.persist(user1);
		session.persist(user2);
		
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
}
