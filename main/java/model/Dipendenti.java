package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dipendenti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private String telefono;
	private String mail;
	private String password;
	private long idruolo;
	private String dataassunzione;
	private double costoorario;
	
	//costruttori
	
	public Dipendenti() {
		super();
		
	}

	public Dipendenti(String nome, String telefono, String mail, String password, long idruolo, String dataassunzione,
			double costoorario) {
		super();
		this.nome = nome;
		this.telefono = telefono;
		this.mail = mail;
		this.password = password;
		this.idruolo = idruolo;
		this.dataassunzione = dataassunzione;
		this.costoorario = costoorario;
	}
	
	//metodi getter e setter
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdruolo() {
		return idruolo;
	}

	public void setIdruolo(long idruolo) {
		this.idruolo = idruolo;
	}

	public String getDataassunzione() {
		return dataassunzione;
	}

	public void setDataassunzione(String dataassunzione) {
		this.dataassunzione = dataassunzione;
	}

	public double getCostoorario() {
		return costoorario;
	}

	public void setCostoorario(double costoorario) {
		this.costoorario = costoorario;
	}
	
	@Override
	public String toString() { //deve aggiumgere idruolo????
		return "Id= " + id + ", Nome= " + nome + ", Telefono= " + telefono + ", Mail= " + mail + ", Data assunzione= " + dataassunzione + ", Costo orario= " + costoorario + "\n";
	}
	
	
	
	
}
