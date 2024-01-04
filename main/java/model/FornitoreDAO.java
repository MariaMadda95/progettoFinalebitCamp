package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface FornitoreDAO {

	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void add(Fornitore fornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(fornitore);
		tx.commit();
		session.close();
	}

	public static void update(Fornitore fornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(fornitore);
		tx.commit();
		session.close();
	}

	public static void delete(Fornitore fornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(fornitore);
		tx.commit();
		session.close();
	}

	public static List<Fornitore> getAllFornitore() {
		Session session = sessionFactory.openSession();
		Query<Fornitore> query = session.createQuery("FROM Fornitore", Fornitore.class);
		List<Fornitore> listaFornitori = query.getResultList();
		session.close();
		return listaFornitori;
	}

	public static Fornitore getFornitoreById(long id) {
		Session session = sessionFactory.openSession();
		Fornitore fornitore = session.get(Fornitore.class, id);
		session.close();
		return fornitore;
	}

	public static List<Fornitore> getFornitoreNome(String nome) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Fornitore f WHERE f.nome = :nome";
		Query<Fornitore> query = session.createQuery(hql, Fornitore.class);
		query.setParameter("nome", nome);
		List<Fornitore> listaFornitori = query.getResultList();
		session.close();
		return listaFornitori;
	}

	public static List<Fornitore> getFornitoreTelefono(String telefono) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Fornitore f WHERE f.telefono = :telefono";
		Query<Fornitore> query = session.createQuery(hql, Fornitore.class);
		query.setParameter("telefono", telefono);
		List<Fornitore> listaFornitori = query.getResultList();
		session.close();
		return listaFornitori;
	}

	public static List<Fornitore> getFornitoreMail(String mail) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Fornitore f WHERE f.mail = :mail";
		Query<Fornitore> query = session.createQuery(hql, Fornitore.class);
		query.setParameter("mail", mail);
		List<Fornitore> listaFornitori = query.getResultList();
		session.close();
		return listaFornitori;
	}

	public static List<Fornitore> getFornitoreReferente(String referente) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Fornitore f WHERE f.referente = :referente";
		Query<Fornitore> query = session.createQuery(hql, Fornitore.class);
		query.setParameter("referente", referente);
		List<Fornitore> listaFornitori = query.getResultList();
		session.close();
		return listaFornitori;
	}

}
