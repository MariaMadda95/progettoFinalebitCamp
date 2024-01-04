package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Magazzino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private Long idprodotto;
	private int disponibilita;
	private String nomeProdotto;
	
	// costruttore vuoto
	public Magazzino() {
		
	}
	
	//costruttore
	public Magazzino (Long idprodotto, int disponibilita) {
		this.idprodotto=idprodotto;
		this.disponibilita=disponibilita; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdprodotto() {
		return idprodotto;
	}

	public void setIdprodotto(Long idprodotto) {
		this.idprodotto = idprodotto;
	}

	public int getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	public String getNomeProdotto() {
		return nomeProdotto;
	}
	
	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	@Override
	public String toString() {
		return "Magazzino [id=" + id + ", idprodotto=" + idprodotto + ", disponibilita=" + disponibilita + "]";
	}
	
	
}
