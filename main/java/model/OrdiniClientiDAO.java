package model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public interface OrdiniClientiDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//add cliente
		public static void add(OrdiniClienti ordineCliente) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(ordineCliente);
			tx.commit();
			session.close();
		}
		//modifica cliente
		public static void update(OrdiniClienti ordineCliente) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(ordineCliente);
			tx.commit();
			session.close();
		}
		//elimina cliente
		public static void delete(OrdiniClienti ordineCliente) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(ordineCliente);
			tx.commit();
			session.close();
		}
		//ritorna tutti i clienti
		public static List<OrdiniClienti> getAllOrdiniClienti(){
			Session session = sessionFactory.openSession();
			Query<OrdiniClienti> query = session.createQuery("FROM OrdiniClienti", OrdiniClienti.class);
			List<OrdiniClienti> listaOrdiniClienti = query.getResultList();
			session.close();
			return listaOrdiniClienti;
		}
		//ritorna ordini clienti by id
		public static OrdiniClienti getOrdineClienteById(long id) {
			Session session = sessionFactory.openSession();
			OrdiniClienti ordiniCliente = session.get(OrdiniClienti.class, id);
			session.close();
			return ordiniCliente;
		}
		//recupera ordiniclienti per id cliente
		public static List<OrdiniClienti> getOrdiniClientiByIdCliente(long idCliente){
			Session session = sessionFactory.openSession();
			String hql = "FROM OrdiniClienti o WHERE o.idcliente = :idcliente";
			Query<OrdiniClienti> query = session.createQuery(hql, OrdiniClienti.class);
			query.setParameter("idcliente", idCliente);
			List<OrdiniClienti> listaOrdiniClienti = query.getResultList();
			session.close();
			return listaOrdiniClienti;
		}
		//recupera per data ordine
		public static List<OrdiniClienti> getOrdiniClientiData(String dataOrdine){
			Session session = sessionFactory.openSession();
			String hql = "FROM OrdiniClienti o WHERE o.dataordine = :dataordine";
			Query<OrdiniClienti> query = session.createQuery(hql, OrdiniClienti.class);
			query.setParameter("dataordine", dataOrdine);
			List<OrdiniClienti> listaOrdiniClienti = query.getResultList();
			session.close();
			return listaOrdiniClienti;
		}
		//recupera per costo totale
		public static List<OrdiniClienti> getOrdiniClientiCosto(String costoTotale){
			Session session = sessionFactory.openSession();
			String hql = "FROM OrdiniClienti o WHERE o.costoTotale = :costoTotale";
			Query<OrdiniClienti> query = session.createQuery(hql, OrdiniClienti.class);
			query.setParameter("dataordine", costoTotale);
			List<OrdiniClienti> listaOrdiniClienti = query.getResultList();
			session.close();
			return listaOrdiniClienti;
		}
		//cerca per stato
		public static List<OrdiniClienti> getOrdiniClientiStato(String stato){
			Session session = sessionFactory.openSession();
			String hql = "FROM OrdiniClienti o WHERE o.stato = :stato";
			Query<OrdiniClienti> query = session.createQuery(hql, OrdiniClienti.class);
			query.setParameter("dataordine", stato);
			List<OrdiniClienti> listaOrdiniClienti = query.getResultList();
			session.close();
			return listaOrdiniClienti;
		}
}
