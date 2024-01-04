package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class OrdiniClienti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "idcliente")
	private long idCliente;
	private String dataOrdine;
	private double costoTotale;
	private String stato;
	
	public OrdiniClienti() {
		
	}

	public OrdiniClienti(long id, long idCliente, String dataOrdine, double costoTotale, String stato) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.dataOrdine = dataOrdine;
		this.costoTotale = costoTotale;
		this.stato = stato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(String dataordine) {
		this.dataOrdine = dataordine;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
		
	}

	@Override
	public String toString() {
		return "OrdiniClienti [id=" + id + ", idCliente=" + idCliente + ", dataordine=" + dataOrdine + ", costoTotale="
				+ costoTotale + ", stato=" + stato + "]";
	}

	
	
	
	
}
