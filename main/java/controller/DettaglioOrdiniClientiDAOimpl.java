package controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.google.common.collect.Table;

import model.DetOrdCli;
import model.DettaglioOrdineCliente;
import model.DettaglioOrdineClienteDAO;

public class DettaglioOrdiniClientiDAOimpl implements DettaglioOrdineClienteDAO {
	DettaglioOrdineCliente doc = new DettaglioOrdineCliente();
	public void visualizzaElenco(JTable tabella) {
		DefaultTableModel modelloTabella = new DefaultTableModel();
		modelloTabella.addColumn("#");
		modelloTabella.addColumn("Cliente");
		modelloTabella.addColumn("Prodotto");
		modelloTabella.addColumn("Quantità");
		
		List<DetOrdCli> commeVuoiTu = DettaglioOrdineClienteDAO.viewAll();
		for(DetOrdCli doc: commeVuoiTu) {
			Object[] riga = {
				doc.getId(),
				doc.getCliente(),
				doc.getProdotto(),
				doc.getQuantita()
			};
			modelloTabella.addRow(riga);
		}
		
		tabella.setModel(modelloTabella);
		
	}
	
	public void visualizaUno(long id,JTable tabella) {
		DefaultTableModel modelloTabella = new DefaultTableModel();
		modelloTabella.addColumn("#");
		modelloTabella.addColumn("Cliente");
		modelloTabella.addColumn("Prodotto");
		modelloTabella.addColumn("Quantità");
		
		List<DetOrdCli> commeVuoiTu = DettaglioOrdineClienteDAO.viewOne(id);
		for(DetOrdCli doc: commeVuoiTu) {
			Object[] riga = {
				doc.getId(),
				doc.getCliente(),
				doc.getProdotto(),
				doc.getQuantita()
			};
			modelloTabella.addRow(riga);
		}
		
		tabella.setModel(modelloTabella);
	}
}
