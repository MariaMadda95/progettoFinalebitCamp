package controller;

 import java.util.List;

import model.Clienti;
import model.ClientiDAO;

public class ClientiDAOimpl implements ClientiDAO {
	Clienti cliente = new Clienti();
	
	//metodo per aggiungere nuovo cliente
	public void addCliente(String nome, String via, String civico, String citta, String telefono, String mail,
			String password) {
		cliente.setNome(nome);
		cliente.setVia(via);
		cliente.setCivico(civico);
		cliente.setCitta(citta);
		cliente.setTelefono(telefono);
		cliente.setMail(mail);
		cliente.setPassword(password);
		ClientiDAO.add(cliente);
		System.out.println("Cliente aggiunto");
	}
	//metodo per mostrare tutti i clienti
	public List<Clienti> mostraClienti() {
		List<Clienti> cliente = ClientiDAO.getAllClienti();
		for(Clienti c : cliente) {
			System.out.println(c.getId() + " " + c.getNome());
		}
		return cliente;
	}

}
