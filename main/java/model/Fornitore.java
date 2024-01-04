package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornitore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String nome;
	private String telefono;
	private String mail;
	private String referente;
	
	public Fornitore() {
		
	}
	
	public Fornitore(String nome, String telefono, String mail, String referente) {
		this.nome = nome;
		this.telefono= telefono;
		this.mail=mail;
		this.referente = referente;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getReferente() {
		return referente;
	}

	public void setReferente(String referente) {
		this.referente = referente;
	}

	@Override
	public String toString() {
		return "Fornitore [id=" + id + ", nome=" + nome + ", telefono=" + telefono + ", mail=" + mail + ", referente="
				+ referente + "]";
	}
	
	

}
