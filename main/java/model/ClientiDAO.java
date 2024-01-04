package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public interface ClientiDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//add cliente
	public static void add(Clienti cliente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(cliente);
		tx.commit();
		session.close();
	}
	//modifica cliente
	public static void update(Clienti cliente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(cliente);
		tx.commit();
		session.close();
	}
	//elimina cliente
	public static void delete(Clienti cliente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cliente);
		tx.commit();
		session.close();
	}
	//ritorna tutti i clienti
	public static List<Clienti> getAllClienti(){
		Session session = sessionFactory.openSession();
		Query<Clienti> query = session.createQuery("FROM Clienti", Clienti.class);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//ritorna clienti per id
	public static Clienti getClienteById(long id) {
		Session session = sessionFactory.openSession();
		Clienti cliente = session.get(Clienti.class, id);
		session.close();
		return cliente;
	}
	//recupera cliente per nome
	public static List<Clienti> getClientiNome(String nome){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.nome = :nome";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("nome", nome);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera per via
	public static List<Clienti> getClientiVia(String via){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.via = :via";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("via", via);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera per civico
	public static List<Clienti> getClientiCivico(String civico){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.civico = :civico";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("civico", civico);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera per citta
	public static List<Clienti> getClientiCitta(String citta){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.citta = :citta";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("citta", citta);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera per telefono
	public static List<Clienti> getClientiTelefono(String telefono){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.telefono = :telefono";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("telefono", telefono);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera per mail
	public static List<Clienti> getClientiMail(String mail){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.mail = :mail";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("mail", mail);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
	//recupera password
	public static List<Clienti> getClientiPassword(String password){
		Session session = sessionFactory.openSession();
		String hql = "FROM Clienti c WHERE c.password = :password";
		Query<Clienti> query = session.createQuery(hql, Clienti.class);
		query.setParameter("password", password);
		List<Clienti> listaClienti = query.getResultList();
		session.close();
		return listaClienti;
	}
}
