package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OreLavorate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private long iddipendente;
	private String nomedipendente;
	private String mese;
	private int oretotali;
	private int orenormali;
	private int orestraordinarie;
	
	//costruttore
	
	public OreLavorate() {
		super();
		
	}

	public OreLavorate(long iddipendente, String mese, int orenormali, int orestraordinarie) {
		super();
		this.iddipendente = iddipendente;
		this.mese = mese;
		this.orenormali = orenormali;
		this.orestraordinarie = orestraordinarie;
		this.oretotali = orenormali + orestraordinarie;
	}

	//metodi getter e setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomedipendente() {
		return nomedipendente;
	}

	public void setNomedipendente(String nomedipendente) {
		this.nomedipendente = nomedipendente;
	}

	public long getIddipendente() {
		return iddipendente;
	}

	public void setIddipendente(long iddipendente) {
		this.iddipendente = iddipendente;
	}

	public String getMese() {
		return mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public int getOretotali() {
		return oretotali;
	}

	public void setOretotali(int oretotali) {
		this.oretotali = oretotali;
	}

	public int getOrenormali() {
		return orenormali;
	}

	public void setOrenormali(int orenormali) {
		this.orenormali = orenormali;
	}

	public int getOrestraordinarie() {
		return orestraordinarie;
	}

	public void setOrestraordinarie(int orestraordinarie) {
		this.orestraordinarie = orestraordinarie;
	}
	
	Dipendenti dipendente = new Dipendenti();
	
	@Override
	public String toString() {
		return "Id= " + id + ", Nome e Cognome= " + dipendente.getNome() + ", Ore totali= " + oretotali + ", Ore normali= " + orenormali + ", Ore straordinarie " + orestraordinarie; 
	}
	
	
	

	

}
