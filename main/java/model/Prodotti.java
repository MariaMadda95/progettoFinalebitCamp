package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Prodotti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String descrizione;
	private String linkfoto;
	private String materiale;
	private String reparto;
	private double prezzo;
	public Prodotti() {
		
	}
	public Prodotti(long id, String nome, String descrizione, String linkfoto, String materiale, String reparto, double prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.linkfoto = linkfoto;
		this.materiale = materiale;
		this.reparto = reparto;
		this.prezzo = prezzo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLinkfoto() {
		return linkfoto;
	}
	public void setLinkfoto(String linkfoto) {
		this.linkfoto = linkfoto;
	}
	public String getMateriale() {
		return materiale;
	}
	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "Prodotti [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", linkfoto=" + linkfoto
				+ ", materiale=" + materiale + ", reparto=" + reparto + ", prezzo=" + prezzo + "]";
	}
	
}
