package controller;

import java.util.List;
import model.Prodotti;
import model.ProdottiDAO;

public class ProdottiDAOImpl implements ProdottiDAO {
	Prodotti prodotto = new Prodotti();
	

	//metodo 
	public void addProdotti(String nome, String descrizione, String linkfoto, String materiale, String reparto, double prezzo ) {
		prodotto.setNome(nome);
		prodotto.setDescrizione(descrizione);
		prodotto.setLinkfoto(linkfoto);
		prodotto.setMateriale(materiale);
		prodotto.setReparto(reparto);
		prodotto.setPrezzo(prezzo);
		
		ProdottiDAO.add(prodotto);
	}
	
	public void modificaProdotti(String nome, String descrizione, String linkfoto, String materiale, String reparto, double prezzo) {
		 prodotto.setNome(nome);
         prodotto.setDescrizione(descrizione);
         prodotto.setLinkfoto(linkfoto);
         prodotto.setMateriale(materiale);
         prodotto.setReparto(reparto);
         prodotto.setPrezzo(prezzo);

         ProdottiDAO.update(prodotto);
	}

	public List<Prodotti> showProdotti(){
		List<Prodotti> prodotti = ProdottiDAO.getAllProdotti();
		return prodotti;

	}
}
