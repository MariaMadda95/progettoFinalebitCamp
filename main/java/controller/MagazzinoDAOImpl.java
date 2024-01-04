package controller;

import java.util.List;
import model.MagazzinoDAO;

import model.Magazzino;
import model.Prodotti;


public class MagazzinoDAOImpl implements MagazzinoDAO {
     Magazzino magazzino = new Magazzino();
     
     //metodo
     public void addProdottiInMag(Long idprodotto, int disponibilita ) {
    	 magazzino.setIdprodotto(idprodotto);
    	 magazzino.setDisponibilita(disponibilita);
    	 
 		MagazzinoDAO.add(magazzino);
 	}
     
     public List<Magazzino> vediMagazzino() {
    	List<Magazzino> magazzino = MagazzinoDAO.getAllProdottiNome();
    	for(Magazzino m : magazzino) {
    	}
    	return magazzino;
     }
     
     public List<Magazzino> vediMagazzinoNome(String nome) {
    	 List<Magazzino> magazzino = MagazzinoDAO.getProdottiNome(nome);
     	for(Magazzino m : magazzino) {
     	}
     	return magazzino;
     }
     
     
     
	
}
