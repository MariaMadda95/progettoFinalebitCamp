package controller;

import model.OrdiniClienti;
import model.OrdiniClientiDAO;

public class OrdiniClientiDAOimpl implements OrdiniClientiDAO {
	OrdiniClienti ordineCliente = new OrdiniClienti();
	
	public void modificaStato(String stato) {
		OrdiniClienti ordineClienteMod = new OrdiniClienti();
		ordineClienteMod.setStato(stato);
		OrdiniClientiDAO.update(ordineClienteMod);
	}
}
