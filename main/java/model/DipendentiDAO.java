package model;

import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface DipendentiDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public static void save(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dipendente);
		tx.commit();
		session.close();
	}
	
	public static void update(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dipendente);
		tx.commit();
		session.close();
	}
	
	public static void delete(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dipendente);
		tx.commit();
		session.close();
	}
	
	public static List<Dipendenti> getAllDipendenti() {
		Session session = sessionFactory.openSession();
		Query<Dipendenti> query = session.createQuery("FROM Dipendenti", Dipendenti.class);
		List<Dipendenti> listaDipendenti = query.getResultList();
		session.close();
		return listaDipendenti;
	}
	
	public static Dipendenti getDipendentiById(long id) {
		Session session = sessionFactory.openSession();
		Dipendenti dipendente = session.get(Dipendenti.class, id);
		session.close();
		return dipendente;
	}
	
	//devo aggiungere altri metodi

}
