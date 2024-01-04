package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface DettaglioOrdineFornitoriDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void add(DettaglioOrdineFornitori dettaglioOrdineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dettaglioOrdineFornitore);
		tx.commit();
		session.close();
	}

	public static void update(DettaglioOrdineFornitori dettaglioOrdineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dettaglioOrdineFornitore);
		tx.commit();
		session.close();
	}

	public static void delete(DettaglioOrdineFornitori dettaglioOrdineFornitore) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dettaglioOrdineFornitore);
		tx.commit();
		session.close();
	}

	public static List<DettaglioOrdineFornitori> getAllDettOrdiniFornitori() {
		Session session = sessionFactory.openSession();
		Query<DettaglioOrdineFornitori> query = session.createQuery("FROM DettaglioOrdineFornitori",
				DettaglioOrdineFornitori.class);
		List<DettaglioOrdineFornitori> listaDettOrdineFornitori = query.getResultList();
		session.close();
		return listaDettOrdineFornitori;
	}

	public static DettaglioOrdineFornitori getDettOrdineFornitoriById(long id) {
		Session session = sessionFactory.openSession();
		DettaglioOrdineFornitori dettOrdineFornitore = session.get(DettaglioOrdineFornitori.class, id);
		session.close();
		return dettOrdineFornitore;
	}

	public static List<DettaglioOrdineFornitori> getDettOrdFornByIdOrdForn(Long idordinefornitore) {
		Session session = sessionFactory.openSession();
		String hql = "FROM DettaglioOrdineFornitori o WHERE o.idordinefornitore = :idordinefornitore";
		Query<DettaglioOrdineFornitori> query = session.createQuery(hql, DettaglioOrdineFornitori.class);
		query.setParameter("idordinefornitore", idordinefornitore);
		List<DettaglioOrdineFornitori> listaDettOrdineFornitori = query.getResultList();
		session.close();
		return listaDettOrdineFornitori;
	}
	
	public static List<Object[]> getDettaglioOrdFornById(long id){
		Session session = sessionFactory.openSession();
        String hql = "SELECT prod.nome, prod.descrizione, prod.prezzo, dett.quantita FROM DettaglioOrdineFornitori dett JOIN Prodotti prod on dett.idprodotto = prod.id WHERE dett.idordinefornitore = :idordinefornitore";
        Query query = session.createQuery(hql);
        query.setParameter("idordinefornitore", id);
        List<Object[]> listaRisultati = new ArrayList<>();
        List<Object[]> resuList = query.getResultList();
        
        for (Object[] lista : resuList) {
        	listaRisultati.add(lista);
        }
        
        session.close();
        return listaRisultati;
	}

}
