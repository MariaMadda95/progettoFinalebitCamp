package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Dipendenti;
import model.OreLavorate;
import model.OreLavorateDAO;

public class OreLavorateDAOimpl implements OreLavorateDAO{
	
	public void save(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public void update(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public void delete(OreLavorate oreLavorate) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(oreLavorate);
		tx.commit();
		session.close();
	}
	
	public List<OreLavorate> getAllOreLavorate() {
		Session session = sessionFactory.openSession();
		Query<OreLavorate> query = session.createQuery("FROM OreLavorate", OreLavorate.class);
		List<OreLavorate> listaOreLavorate = query.getResultList();
		session.close();
		return listaOreLavorate;
	}
	
	public OreLavorate getOreLavorateById(Long id) {
		Session session = sessionFactory.openSession();
		OreLavorate oreLavorate = session.get(OreLavorate.class, id);
		session.close();
		return oreLavorate;
	}
	
	public List<OreLavorate> getAllOreNomeDip() {
		Session session = sessionFactory.openSession();
		String hQuery = "SELECT o.id, d.nome, o.mese, o.orenormali, o.orestraordinarie, o.oretotali FROM OreLavorate o JOIN Dipendenti d ON o.iddipendente = d.id";
		Query<Object[]> query = session.createQuery(hQuery, Object[].class);
		List<OreLavorate> listaRisultati = new ArrayList<>();
		List<Object[]> resuList = (List)query.getResultList();
		for(Object[] result: resuList) {
			OreLavorate o = new OreLavorate();
			Dipendenti d = new Dipendenti();
			o.setId((Long) result[0]);
			o.setNomedipendente((String) result[1]);
			o.setMese((String) result[2]);
			o.setOrenormali((Integer) result[3]);
			o.setOrestraordinarie((Integer) result[4]);
			o.setOretotali((Integer) result[5]);
			listaRisultati.add(o);
		}
		session.close();
		return listaRisultati;
	}
	
	public void visualizzaElencoOre(JTable tabella) {
		DefaultTableModel risElencoOre = new DefaultTableModel();
		risElencoOre.addColumn("ID");
		risElencoOre.addColumn("Cognome e Nome");
		risElencoOre.addColumn("Mese");
		risElencoOre.addColumn("Ore ordinarie");
		risElencoOre.addColumn("Ore straordinarie");
		risElencoOre.addColumn("Ore totali");
		String[] titoli = {"ID", "Cognome e Nome", "Mese", "Ore normali", "Ore straordinarie","Ore totali"};
		risElencoOre.setColumnIdentifiers(titoli);
		
		List<OreLavorate> record = this.getAllOreNomeDip();
		for(OreLavorate oL: record) {
			Object[] riga = {
				oL.getId(),
				oL.getNomedipendente(),
				oL.getMese(),
				oL.getOrenormali(),
				oL.getOrestraordinarie(),
				oL.getOretotali(),	
			};
			risElencoOre.addRow(riga);
		}
		tabella.setModel(risElencoOre);
	}

}
