package model;

import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface OreLavorateDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public static void save(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public static void update(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public static void delete(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public static List<OreLavorate> getAllOreLavorate() {
		Session session = sessionFactory.openSession();
		Query<OreLavorate> query = session.createQuery("FROM OreLavorate", OreLavorate.class);
		List<OreLavorate> listaOreLavorate = query.getResultList();
		session.close();
		return listaOreLavorate;
	}
	
	public static OreLavorate getOreLavorateById(Long id) {
		Session session = sessionFactory.openSession();
		OreLavorate oreLavorate = session.get(OreLavorate.class, id);
		session.close();
		return oreLavorate;
	}
	
	//devo aggiungere altri metodi

}
