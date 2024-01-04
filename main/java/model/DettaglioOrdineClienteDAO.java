package model;

import java.util.ArrayList;
import java.util.List;
import model.DettaglioOrdineCliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public interface DettaglioOrdineClienteDAO {
	final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	// visualizza DettOrdine
	public static List<DetOrdCli> viewAll() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT det.id, cli.nome, prod.nome, det.quantita FROM DettaglioOrdineCliente det JOIN OrdiniClienti ord ON det.idordinecliente = ord.id JOIN Prodotti prod ON det.idprodotto = prod.id JOIN Clienti cli ON ord.idCliente = cli.id";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<DetOrdCli> listaRisultati = new ArrayList<>();
		List<Object[]> resuList = (List) query.getResultList();
		for (Object[] result : resuList) {
			DetOrdCli detOrdCli = new DetOrdCli();
			detOrdCli.setId((Long) result[0]);
			detOrdCli.setCliente((String) result[1]);
			detOrdCli.setProdotto((String) result[2]);
			detOrdCli.setQuantita((Integer) result[3]);
			listaRisultati.add(detOrdCli);
		}
		session.close();
		return listaRisultati;
	}

	public static List<DetOrdCli> viewOne(long id) {
		Session session = sessionFactory.openSession();
		String hql = "SELECT det.id, cli.nome, prod.nome, det.quantita FROM DettaglioOrdineCliente det JOIN OrdiniClienti ord ON det.idordinecliente = ord.id JOIN Prodotti prod ON det.idprodotto = prod.id JOIN Clienti cli ON ord.idCliente = cli.id WHERE ord.id = :orderID";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		query.setParameter("orderID", id);
		List<DetOrdCli> listaRisultati = new ArrayList<>();
		List<Object[]> resuList = (List) query.getResultList();
		for (Object[] result : resuList) {
			DetOrdCli detOrdCli = new DetOrdCli();
			detOrdCli.setId((Long) result[0]);
			detOrdCli.setCliente((String) result[1]);
			detOrdCli.setProdotto((String) result[2]);
			detOrdCli.setQuantita((Integer) result[3]);
			listaRisultati.add(detOrdCli);
		}
		session.close();
		return listaRisultati;
	}
}
