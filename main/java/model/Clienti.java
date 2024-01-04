package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clienti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String via;
	private String civico;
	private String citta;
	private String telefono;
	private String mail;
	private String password;
	
	public Clienti() {
		
	}
	
	public Clienti(String nome, String via, String civico, String citta, String telefono, String mail,
			String password) {
		super();
		this.nome = nome;
		this.via = via;
		this.civico = civico;
		this.citta = citta;
		this.telefono = telefono;
		this.mail = mail;
		this.password = password;
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
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCivico() {
		return civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Clienti [id=" + id + ", nome=" + nome + ", via=" + via + ", civico=" + civico + ", citta=" + citta
				+ ", telefono=" + telefono + ", email=" + mail + ", password=" + password + "]";
	}
	
	
}
