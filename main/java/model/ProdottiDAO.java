package model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface ProdottiDAO {
	final SessionFactory sessionfactory = HibernateUtil.getSessionFactory();
	
	//aggiugere prodotto
	public static void  add(Prodotti prodotto) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(prodotto);
		tx.commit();
		session.close();
		
		}
	
	//modificare prodotto
	public static void update(Prodotti prodotto) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(prodotto);
		tx.commit();
		session.close();
	}
	
	//elimina prodotto
	public static void delete (Prodotti prodotto) {
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(prodotto);
		tx.commit();
		session.close();
	}
	
	//per vedere tutti i prodotti
	public static List<Prodotti> getAllProdotti(){
		Session session = sessionfactory.openSession();
		Query<Prodotti> query = session.createQuery("FROM Prodotti" , Prodotti.class);
		List<Prodotti> listaProdotti = query.getResultList();
		session.close();
		return listaProdotti;
	}
	
	//per vedere i prodotti selezionati per ID
	public static  Prodotti getProdottiById(long id) {
		Session session = sessionfactory.openSession();
		Prodotti prodotto = session.get(Prodotti.class, id);
		session.close();
		return prodotto;
	}
	
	// per vedere i prodotti in base al materiale
	public static List<Prodotti> getProdottiByMateriale(String materiale){
		Session session = sessionfactory.openSession();
		Query<Prodotti> query = session.createQuery("FROM Prodotti p WHERE p.materiale = :materiale" , Prodotti.class);
		query.setParameter("materiale", materiale);
		List<Prodotti> listaProdotti = query.getResultList();
		session.close();
		return listaProdotti;
	}
	
	// per vedere i prodotti in base al reparto
	public static List<Prodotti> getProdottiByReparto(String reparto){
		Session session = sessionfactory.openSession();
		Query<Prodotti> query = session.createQuery("FROM Prodotti p WHERE p.reparto = :reparto" , Prodotti.class);
		query.setParameter("reparto", reparto);
		List<Prodotti> listaProdotti = query.getResultList();
		session.close();
		return listaProdotti;
	}
	
	// per vedere i prodotti in base al prezzo  
	public static List<Prodotti> getProdottiByPrezzo(double prezzo){
		Session session = sessionfactory.openSession();
		Query<Prodotti> query = session.createQuery("FROM Prodotti p WHERE p.prezzo = :prezzo" , Prodotti.class);
		query.setParameter("prezzo", prezzo);
		List<Prodotti> listaProdotti = query.getResultList();
		session.close();
		return listaProdotti;
	}
	
	
	// per vedere i prodotti in base al nome
	public static List<Prodotti> getProdottiByName(String nome){
		Session session = sessionfactory.openSession();
		Query<Prodotti> query = session.createQuery("FROM Prodotti p WHERE p.nome = :nome" , Prodotti.class);
		query.setParameter("nome", nome);
		List<Prodotti> listaProdotti = query.getResultList();
		session.close();
		return listaProdotti;
	}
	
	
}
