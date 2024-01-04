package model;

public class DetOrdCli {
	private long id;
	private String cliente;
	private String prodotto;
	private int quantita;
	
	public DetOrdCli() {
		
	}
	public DetOrdCli(long id, String cliente, String prodotto, int quantita) {
		this.id = id;
		this.cliente = cliente;
		this.prodotto = prodotto;
		this.quantita = quantita;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "DetOrdCli [id=" + id + ", cliente=" + cliente + ", prodotto=" + prodotto + ", quantita=" + quantita
				+ "]";
	}
	
	
}
