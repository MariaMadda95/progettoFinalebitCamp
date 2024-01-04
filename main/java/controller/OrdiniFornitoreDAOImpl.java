package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.DettaglioOrdineFornitori;
import model.DettaglioOrdineFornitoriDAO;
import model.Fornitore;
import model.FornitoreDAO;
import model.OrdiniFornitori;
import model.OrdiniFornitoriDAO;
import net.bytebuddy.asm.Advice.Local;

public class OrdiniFornitoreDAOImpl implements OrdiniFornitoriDAO, DettaglioOrdineFornitoriDAO {
	OrdiniFornitori ordineFornitore = new OrdiniFornitori();
	DettaglioOrdineFornitori dettaglioOrdineFornitore = new DettaglioOrdineFornitori();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public void addOrdineFornitore(long idfornitore, String dataordine, List<Object[]> datiProdotto) {
		LocalDate dataordineForm = LocalDate.parse(dataordine, formatter);
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataSpedizione = dataordineForm.plusDays(2);
		LocalDate dataArrivo = dataordineForm.plusDays(5);
		String stato = "";
		List<DettaglioOrdineFornitori> dettOrdForn = new ArrayList<>();
		double costototale = 0.00;

		if (dataSpedizione.isAfter(dataAttuale)) {
			stato = "In Preparazione";
		} else if (dataArrivo.isBefore(dataAttuale)) {
			stato = "Consegnato";
		} else if (dataSpedizione.isBefore(dataAttuale) && dataArrivo.isAfter(dataAttuale)) {
			stato = "In Spedizione";
		}
		System.out.println(stato);
		for (Object[] datoProdotto : datiProdotto) {
			double prezzo = (double) datoProdotto[1];
			int quantita = (int) datoProdotto[2];
			double costo = prezzo * quantita;
			costototale += costo;

		}
		
		//aggiungo l'ordine al database
		ordineFornitore.setIdfornitore(idfornitore);
		ordineFornitore.setDataordine(dataordine);
		ordineFornitore.setCostototale(costototale);
		ordineFornitore.setStato(stato);
		OrdiniFornitoriDAO.add(ordineFornitore);
		
		long idordinefornitore = ordineFornitore.getId();
		
		for (Object[] datoProdotto : datiProdotto) {
			long idprodotto = (long) datoProdotto[0];
			int quantita = (int) datoProdotto[2];
			
			dettaglioOrdineFornitore.setIdordinefornitore(idordinefornitore);
			dettaglioOrdineFornitore.setIdprodotto(idprodotto);
			dettaglioOrdineFornitore.setQuantita(quantita);
			DettaglioOrdineFornitoriDAO.add(dettaglioOrdineFornitore);
			

		}
		
		
		}
	
	public List<Object[]> showDettaglioOrdFornById(long id){
		List<Object[]> dettaglioOrdine = DettaglioOrdineFornitoriDAO.getDettaglioOrdFornById(id);
		return dettaglioOrdine;
	
	}
	
	public List<OrdiniFornitori> showAllOrdForn() {
		List<OrdiniFornitori> Ordinifornitore = OrdiniFornitoriDAO.getAllOrdiniFornitori();
		return Ordinifornitore;
	}
}
