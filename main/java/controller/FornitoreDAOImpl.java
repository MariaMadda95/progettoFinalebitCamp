package controller;

import java.util.List;

import model.Fornitore;
import model.FornitoreDAO;

public class FornitoreDAOImpl implements FornitoreDAO {
	Fornitore fornitore = new Fornitore();
	
	public void addFornitore(String nome, String telefono, String mail, String referente ) {
		fornitore.setNome(nome);
		fornitore.setTelefono(telefono);
		fornitore.setMail(mail);
		fornitore.setReferente(referente);
		FornitoreDAO.add(fornitore);
		System.out.println("Cliente aggiunto con successo");
	}
	
	public List<Fornitore> showAllFornitori() {
		List<Fornitore> fornitore = FornitoreDAO.getAllFornitore();
		return fornitore;
	}
}
