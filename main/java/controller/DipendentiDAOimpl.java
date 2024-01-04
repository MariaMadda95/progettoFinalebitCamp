package controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.common.collect.Table;

import model.Dipendenti;
import model.DipendentiDAO;


public class DipendentiDAOimpl implements DipendentiDAO{
	//Dipendenti dipendente = new Dipendenti();
	
	public void save(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dipendente);
		tx.commit();
		session.close();
	}
	
	public void update(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(dipendente);
		tx.commit();
		session.close();
	}
	
	public void delete(Dipendenti dipendente) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(dipendente);
		tx.commit();
		session.close();
	}
	
	public List<Dipendenti> getAllDipendenti() {
		Session session = sessionFactory.openSession();
		Query<Dipendenti> query = session.createQuery("FROM Dipendenti", Dipendenti.class);
		List<Dipendenti> listaDipendenti = query.getResultList();
		session.close();
		return listaDipendenti;
	}
	
	public Dipendenti getDipendentiById(long id) {
		Session session = sessionFactory.openSession();
		Dipendenti dipendente = session.get(Dipendenti.class, id);
		session.close();
		return dipendente;
	}
	
	public void visualizzaElenco(JTable tabella) {
		DefaultTableModel risElenco = new DefaultTableModel();
		risElenco.addColumn("ID");
		risElenco.addColumn("Cognome e Nome");
		risElenco.addColumn("Telefono");
		risElenco.addColumn("Mail");
		//risElenco.addColumn("Password");
		//risElenco.addColumn("Ruolo");
		risElenco.addColumn("Data assunzione");
		risElenco.addColumn("Costo orario");
		String[] titoli = {"ID", "Cognome e Nome", "Telefono", "Mail", "Data assunzione", "Costo orario"};
		risElenco.setColumnIdentifiers(titoli);
		
		List<Dipendenti> dipList = DipendentiDAO.getAllDipendenti();
		for(Dipendenti d:dipList) {
			Object[] riga = {
					d.getId(),
					d.getNome(),
					d.getTelefono(),
					d.getMail(),
					d.getDataassunzione(),
					d.getCostoorario()
			};
			risElenco.addRow(riga);
		}
		
		tabella.setModel(risElenco);
	}

}
