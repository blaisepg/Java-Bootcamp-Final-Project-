package com.gc.model;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.gc.util.HibernateUtil;

public class DAOUserImpl implements DAOUser {

	@Override
	public void createUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(user);
		tx.commit();
		session.close();
		
	}

	@Override
	public User getUser(String email) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("email", email));
		
		User userWithThisEmail = (User) crit.uniqueResult();
		System.out.println("This is returning user email: " + userWithThisEmail);
		tx.commit();
		session.close();
		
		return userWithThisEmail;
		
		
	}

}
















