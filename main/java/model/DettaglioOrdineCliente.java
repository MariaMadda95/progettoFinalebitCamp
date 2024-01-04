package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DettaglioOrdineCliente {
	@ManyToOne
	@JoinColumn(name = "idcliente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String idordinecliente;
	private String idprodotto;
	private int quantita;
	
	public DettaglioOrdineCliente() {
		
	}
	
	public DettaglioOrdineCliente(long id, String cliente, String prodotto, int quantita) {
		super();
		this.id = id;
		this.idordinecliente = cliente;
		this.idprodotto = prodotto;
		this.quantita = quantita;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdordinecliente() {
		return idordinecliente;
	}

	public void setIdordinecliente(String cliente) {
		this.idordinecliente = cliente;
	}

	public String getIdprodotto() {
		return idprodotto;
	}

	public void setidprodotto(String prodotto) {
		this.idprodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "DettaglioOrdineCliente [id=" + id + ", cliente=" + idordinecliente + ", prodotto=" + idprodotto + ", quantita="
				+ quantita + "]";
	}
	
}
