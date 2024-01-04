package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DettaglioOrdineFornitori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private long idordinefornitore;
	private long idprodotto;
	private int quantita;
	
	public DettaglioOrdineFornitori() {
		
	}
	

	public DettaglioOrdineFornitori(long idordinefornitore, long idprodotto, int quantita) {
		super();
		this.idordinefornitore = idordinefornitore;
		this.idprodotto = idprodotto;
		this.quantita = quantita;
	}


	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdordinefornitore() {
		return idordinefornitore;
	}

	public void setIdordinefornitore(Long idordinefornitore) {
		this.idordinefornitore = idordinefornitore;
	}

	public long getIdprodotto() {
		return idprodotto;
	}

	public void setIdprodotto(Long idprodotto) {
		this.idprodotto = idprodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "DettaglioOrdiniFornitori [id=" + id + ", idordinefornitore=" + idordinefornitore + ", idprodotto="
				+ idprodotto + ", quantita=" + quantita + "]";
	}
	
	
	
}
