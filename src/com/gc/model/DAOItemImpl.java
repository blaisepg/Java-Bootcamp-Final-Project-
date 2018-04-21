package com.gc.model;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.gc.util.HibernateUtil;

public class DAOItemImpl implements DAOItem {

	@Override
	public void addItem(Item item) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(item);
		tx.commit();
		session.close();
	}

	@Override
	public ArrayList<Item> getClosetItems(User user1) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		Criteria crit = session.createCriteria(Item.class);
		crit.add(Restrictions.eq("userId", user1.getUserId()));
		crit.add(Restrictions.eq("inHamp", "F"));
		
		ArrayList<Item> itemList = (ArrayList<Item>) crit.list();
		System.out.println(itemList.size());
		
		tx.commit();
		session.close();
		return itemList;
	}
	
	@Override
	public Item getItem(int itemId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(Item.class);
		crit.add(Restrictions.eq("itemId", itemId));
		
		Item itemWithThisId =  (Item) crit.uniqueResult();
		
		tx.commit();
		session.close();
		return itemWithThisId;
	}

	@Override
	public void deleteItem(Item item) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(item);
		tx.commit();
		session.close();
		
	}

	@Override
	public ArrayList<Item> getOutfit() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(Item.class);
		//crit.add(Restrictions.like(propertyName, value))
		ArrayList<Item> outfit = (ArrayList<Item>)crit.list();
		tx.commit();
		session.close();
		return outfit;
	}

	@Override
	public void changeHampStatus(Item item){
		
		if (item.getInHamp().equals("T")) {
			item.setInHamp("F");
		}
		else {
			item.setInHamp("T");
		}

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.update(item);
		tx.commit();
		session.close();
	}
	
	
	@Override
	public ArrayList<Item> getHamperItems(User user1){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria crit = session.createCriteria(Item.class);
		crit.add(Restrictions.eq("userId", user1.getUserId()));
		crit.add(Restrictions.eq("inHamp", "T"));
		
		
		ArrayList<Item> hamperItemList = (ArrayList<Item>) crit.list();
		
		tx.commit();
		session.close();
		return hamperItemList;
	}

}
