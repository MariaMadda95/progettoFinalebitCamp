package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrdiniFornitori {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private long idfornitore;
	private String dataordine;
	private double costototale;
	private String stato;
	
	public OrdiniFornitori() {
		
	}
		
	
	public OrdiniFornitori(long idfornitore, String dataordine, double costototale, String stato) {
		super();
		this.idfornitore = idfornitore;
		this.dataordine = dataordine;
		this.costototale = costototale;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "OrdiniFornitori [id=" + id + ", idfornitore=" + idfornitore + ", dataordine=" + dataordine
				+ ", costototale=" + costototale + ", stato=" + stato + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdfornitore() {
		return idfornitore;
	}

	public void setIdfornitore(Long idfornitore) {
		this.idfornitore = idfornitore;
	}

	public String getDataordine() {
		return dataordine;
	}

	public void setDataordine(String dataordine) {
		this.dataordine = dataordine;
	}

	public double getCostototale() {
		return costototale;
	}

	public void setCostototale(double costototale) {
		this.costototale = costototale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}
	
	
	
	
}
