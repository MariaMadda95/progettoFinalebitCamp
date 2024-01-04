package model;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface MagazzinoDAO {
	final SessionFactory sessionfactory = HibernateUtil.getSessionFactory();

	// aggiugere prodotto al magazzino
	public static void add(Magazzino elementoMagazzino) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(elementoMagazzino);
		tx.commit();
		session.close();

	}

	// modificare prodotto
	public static void update(Magazzino elementoMagazzino) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(elementoMagazzino);
		tx.commit();
		session.close();
	}

	// elimina prodotto
	public static void delete(Magazzino elementoMagazzino) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(elementoMagazzino);
		tx.commit();
		session.close();
	}

	// per vedere la disponibilità prodotti
	public static List<Magazzino> getAllProdotti() {
		Session session = sessionfactory.openSession();
		Query<Magazzino> query = session.createQuery("FROM Magazzino", Magazzino.class);
		List<Magazzino> listaProdottiMagazzino = query.getResultList();
		session.close();
		return listaProdottiMagazzino;
	}

	// per vedere i prodotti selezionati per ID
	public static Prodotti getProdottiById(Long id) {
		Session session = sessionfactory.openSession();
		Prodotti prodotto = session.get(Prodotti.class, id);
		session.close();
		return prodotto;
	}
	
	public static List<Magazzino> getAllProdottiNome(){
		Session session = sessionfactory.openSession();
		String hql = "SELECT m.id, p.nome, m.disponibilita FROM Magazzino m JOIN Prodotti p ON m.idprodotto = p.id ";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Magazzino> listaMagazzino = new ArrayList<>();
		List<Object[]> resuList = (List) query.getResultList();
		for (Object[] result : resuList) {
			Magazzino mag = new Magazzino();
			mag.setId((Long) result[0]);
			mag.setNomeProdotto((String) result[1]);
			mag.setDisponibilita((int) result[2]);
			listaMagazzino.add(mag);
		}
		session.close();
		return listaMagazzino;
	}
	
	public static List<Magazzino> getProdottiNome(String nomeProdotto){
		Session session = sessionfactory.openSession();
		String hql = "SELECT m.id, p.nome, m.disponibilita FROM Magazzino m JOIN Prodotti p ON m.idprodotto = p.id WHERE p.nome = :nome ";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		query.setParameter("nome", nomeProdotto);
		List<Magazzino> listaMagazzino = new ArrayList<>();
		List<Object[]> resuList = (List) query.getResultList();
		for (Object[] result : resuList) {
			Magazzino mag = new Magazzino();
			mag.setId((Long) result[0]);
			mag.setNomeProdotto((String) result[1]);
			mag.setDisponibilita((int) result[2]);
			listaMagazzino.add(mag);
		}
		session.close();
		return listaMagazzino;
	}

}
