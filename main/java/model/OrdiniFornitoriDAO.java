package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface OrdiniFornitoriDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	

	public static void add(OrdiniFornitori ordineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(ordineFornitore);
		tx.commit();
		session.close();
	}

	public static void update(OrdiniFornitori ordineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(ordineFornitore);
		tx.commit();
		session.close();
	}

	public static void delete(OrdiniFornitori ordineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(ordineFornitore);
		tx.commit();
		session.close();
	}

	public static List<OrdiniFornitori> getAllOrdiniFornitori() {
		Session session = sessionFactory.openSession();
		Query<OrdiniFornitori> query = session.createQuery("FROM OrdiniFornitori", OrdiniFornitori.class);
		List<OrdiniFornitori> listaOrdiniFornitori = query.getResultList();
		session.close();
		return listaOrdiniFornitori;
	}

	public static OrdiniFornitori getOrdiniFornitoriById(long id) {
		Session session = sessionFactory.openSession();
		OrdiniFornitori OrdineFornitore = session.get(OrdiniFornitori.class, id);
		session.close();
		return OrdineFornitore;
	}

	public static List<OrdiniFornitori> getOrdFornByIdForn(long idfornitore) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OrdiniFornitori o WHERE o.idfornitore = :idfornitore";
		Query<OrdiniFornitori> query = session.createQuery(hql, OrdiniFornitori.class);
		query.setParameter("idfornitore", idfornitore);
		List<OrdiniFornitori> listaOrdiniFornitori = query.getResultList();
		session.close();
		return listaOrdiniFornitori;
	}

	public static List<OrdiniFornitori> getOrdFornByData(String dataordine) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OrdiniFornitori o WHERE o.dataordine = :dataordine";
		Query<OrdiniFornitori> query = session.createQuery(hql, OrdiniFornitori.class);
		query.setParameter("dataordine", dataordine);
		List<OrdiniFornitori> listaOrdiniFornitori = query.getResultList();
		session.close();
		return listaOrdiniFornitori;
	}
	
	public static List<OrdiniFornitori> getOrdFornByRangeCosto(double costomin, double costomax) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OrdiniFornitori o WHERE o.costototale BETWEEN :costoMin AND :costoMax";
		Query<OrdiniFornitori> query = session.createQuery(hql, OrdiniFornitori.class);
		query.setParameter("costoMin", costomin);
		query.setParameter("costomax", costomax);
		List<OrdiniFornitori> listaOrdiniFornitori = query.getResultList();
		session.close();
		return listaOrdiniFornitori;
	}
	
	public static List<OrdiniFornitori> getOrdFornByStato(String stato) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OrdiniFornitori o WHERE o.stato = :stato";
		Query<OrdiniFornitori> query = session.createQuery(hql, OrdiniFornitori.class);
		query.setParameter("stato", stato);
		List<OrdiniFornitori> listaOrdiniFornitori = query.getResultList();
		session.close();
		return listaOrdiniFornitori;
	}


}
