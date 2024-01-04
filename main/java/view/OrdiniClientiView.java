package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DettaglioOrdiniClientiDAOimpl;
 
public class OrdiniClientiView extends JFrame implements ActionListener{
		//dichiarazione degli elementi che compongono l'interfaccia
		private JPanel PNL_Label,PNL_table,PNL_cerca;
		private JTable TBL_visualizzazione;
		private JLabel lBL_title,LBL_cerca;
		private JTextField TXF_cerca;
		private JButton BTN_cerca, BTN_goBack;
	    private DettaglioOrdiniClientiDAOimpl docdi = new DettaglioOrdiniClientiDAOimpl();
		//costruttore dalla classe
		public OrdiniClientiView() {
			//definizione di titolo, dimensioni e caratteristiche del JFrame
			setTitle("Ordini clienti");
			setSize(700,500);
			setLayout(new BorderLayout());
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			//metodo per inizzializzare gli elementi
			inizializeComponent();
			
			// Aggiunta di  uno JScrollPane  alla tabella per visualizzare le intestazioni delle colonne
	        JScrollPane scrollPane = new JScrollPane(TBL_visualizzazione);
			//aggiunta dei pannelli al frame
			add(PNL_Label, BorderLayout.PAGE_START);
			add(PNL_table, BorderLayout.CENTER);
			add(PNL_cerca, BorderLayout.SOUTH);
			add(scrollPane);
			setVisible(true);
		}

		private void inizializeComponent() {		
			//nomi colonne della tabella		
			String [] nomiColonne = {"#","Cliente","Prodotto","Quantità"};
			
			PNL_Label = new JPanel();
			PNL_Label.setLayout(new FlowLayout(FlowLayout.CENTER));
			PNL_table = new JPanel();
			PNL_table.setLayout(new FlowLayout(FlowLayout.CENTER));
			PNL_cerca = new JPanel();
			PNL_cerca.setLayout(new GridLayout(1,3,10,10));
			lBL_title = new JLabel("Dettagli dell'ordine selezionato");
			TBL_visualizzazione = new JTable();
			docdi.visualizzaElenco(TBL_visualizzazione);
			LBL_cerca = new JLabel("Inserisci l'id dell'ordine che vuoi visualizzare");
			TXF_cerca = new JTextField();
			addPlaceholder(TXF_cerca, "                     ");
			BTN_cerca = new JButton("Cerca");
			BTN_cerca.addActionListener(this);
			BTN_goBack = new JButton("←");
			BTN_goBack.addActionListener(this);
			BTN_goBack.setVisible(false);
			
			PNL_table.add(TBL_visualizzazione);
			PNL_Label.add(BTN_goBack);
			PNL_Label.add(lBL_title);
			PNL_cerca.add(LBL_cerca);
			PNL_cerca.add(TXF_cerca);
			PNL_cerca.add(BTN_cerca);
		}
		
		private static void addPlaceholder(JTextField TXF_forniore, String placeholder) {
	        TXF_forniore.setForeground(Color.GRAY); // Colore del testo del placeholder
	        TXF_forniore.setText(placeholder);

	        TXF_forniore.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if ( TXF_forniore.getText().equals(placeholder)) {
	                	 TXF_forniore.setText("");
	                	 TXF_forniore.setForeground(Color.BLACK); // Ripristina il colore del testo normale
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if ( TXF_forniore.getText().isEmpty()) {
	                	 TXF_forniore.setForeground(Color.GRAY);
	                	 TXF_forniore.setText(placeholder);
	                }
	            }
	        });
		}
	        
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==BTN_cerca) {
				try {
				    String idString = TXF_cerca.getText();
				    long id = Long.parseLong(idString);
					docdi.visualizaUno(id,TBL_visualizzazione);
					BTN_goBack.setVisible(true);
				} catch (NumberFormatException ex) {
				    ex.printStackTrace(); // Mostra l'errore nella console
				    JOptionPane.showMessageDialog(this, "Inserisci un valore valido per l'ID", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}else if(e.getSource()==BTN_goBack) {
				docdi.visualizzaElenco(TBL_visualizzazione);
				BTN_goBack.setVisible(false);
			}
			
		}
	

}	

