package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.desktop.AppReopenedEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import controller.FornitoreDAOImpl;
import controller.OrdiniFornitoreDAOImpl;
import controller.ProdottiDAOImpl;
import model.Fornitore;
import model.OrdiniFornitori;
import model.Prodotti;
import model.ProdottiDAO;

public class OrdiniFornitoriView implements ActionListener {
	private static JTextField dataOrdine, quantita;
	private static JComboBox<String> fornitoriBox;
	private static JComboBox<String> prodottiBox;
	private static ArrayList<Long> listaIdProdotti = new ArrayList<>();
    private static ArrayList<Double> listaPrezzi = new ArrayList<>();
	private static FornitoreDAOImpl fornitoriImpl = new FornitoreDAOImpl();
	private static List<Object[]> elementiForm = new ArrayList<>();
	private static DefaultTableModel modello;
	private static JPanel PNL_Label;
	private	 static JPanel PNL_table;
	private static JPanel PNL_cerca;
	private static JLabel lBL_title,LBL_cerca;
	private static JTextField TXF_cerca;
	private static JButton BTN_cerca;
	
	public static void AddOrdForn() {
		JFrame aggiungiOrdiniFrame = new JFrame("Aggiungi un ordine");
		aggiungiOrdiniFrame.setSize(700,500);
		aggiungiOrdiniFrame.setLayout(new BorderLayout());
		aggiungiOrdiniFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aggiungiOrdiniFrame.setLocationRelativeTo(null);
		
	    JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        
		JPanel addOrdFornPanel = new JPanel();
		
		addOrdFornPanel.setLayout(new GridLayout(0,2));
		// compilazione dinamica del menu di selezione di fornitori
		addOrdFornPanel.add(new JLabel("Seleziona Fornitore"));
		
		
		fornitoriBox = new JComboBox<>();
		ArrayList<Long> listaIdfornitore = new ArrayList<>(); // array usato per restituire l'id associato al fornitore
		List<Fornitore> listafornitori = fornitoriImpl.showAllFornitori();

		// ciclo che aggiunge una voce per ogni fornitore presente nel database
		for (Fornitore fornitore : listafornitori) {
			long idfornitore = fornitore.getId();
			String nomeFornitore = fornitore.getNome();
			fornitoriBox.addItem(nomeFornitore);
			listaIdfornitore.add(idfornitore);

		}
		addOrdFornPanel.add(fornitoriBox);

		addOrdFornPanel.add(new JLabel("Data ordine (yyyy-mm-dd)"));
		dataOrdine = new JTextField();
		addOrdFornPanel.add(dataOrdine);

		// compilazione dinamica del menu di selezione dei prodotti
		prodottiBox = new JComboBox<>();
		
		List<Prodotti> listaProdotti = ProdottiDAO.getAllProdotti();
		
		// ciclo che aggiunge una voce per ogni prodoto presente nel database
		for (Prodotti prodotto : listaProdotti) {
			long idprodotto = prodotto.getId();
			String nome = prodotto.getNome();
			double prezzoprodotto = prodotto.getPrezzo();
			String nomeProdotto = nome + String.format(" (%.2f€)", prezzoprodotto);
			prodottiBox.addItem(nomeProdotto);
			listaIdProdotti.add(idprodotto);
			listaPrezzi.add(prezzoprodotto);
		}
		addOrdFornPanel.add(prodottiBox);
		quantita = new JTextField();
		addOrdFornPanel.add(quantita);
		elementiForm.add(new Object[] {prodottiBox, quantita});

		// pulsanti
		JButton addButton = new JButton("Aggiungi");
		addOrdFornPanel.add(addButton);
		JButton addMenuProdotto = new JButton("Seleziona un altro prodotto");
		addOrdFornPanel.add(addMenuProdotto);
		
		aggiungiOrdiniFrame.add(containerPanel);
		aggiungiOrdiniFrame.setVisible(true);
		

		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrdiniFornitoreDAOImpl  nuovoOrdine = new OrdiniFornitoreDAOImpl();
				int indiceFornitori =  fornitoriBox.getSelectedIndex();
				long idfornitore = listaIdfornitore.get(indiceFornitori);
				String data = dataOrdine.getText();
				List<Object[]> datiProdotto = new ArrayList<>();
				for (Object[] elemento : elementiForm) {
					JComboBox<String> comboBox = (JComboBox<String>) elemento[0];
					 JTextField textField = (JTextField) elemento[1];
					 int indiceProdotto = comboBox.getSelectedIndex();
					 int quantita = Integer.parseInt(textField.getText());
					 long idprodotto = listaIdProdotti.get(indiceProdotto);
					 double prezzo = listaPrezzi.get(indiceProdotto);
					 datiProdotto.add(new Object[] {idprodotto, prezzo, quantita});
				}
				
				nuovoOrdine.addOrdineFornitore(idfornitore, data, datiProdotto);
				
				clearFields();
				
			}
		});
		
		addMenuProdotto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 	prodottiBox = new JComboBox<>();
			       
			        List<Prodotti> listaProdotti = ProdottiDAO.getAllProdotti();
			        quantita = new JTextField();

			        for (Prodotti prodotto : listaProdotti) {
			            long idprodotto = prodotto.getId();
			            String nome = prodotto.getNome();
			            double prezzoprodotto = prodotto.getPrezzo();
			            String nomeProdotto = nome + String.format(" (%.2f€)", prezzoprodotto);
			            prodottiBox.addItem(nomeProdotto);
			            listaIdProdotti.add(idprodotto);
			            listaPrezzi.add(prezzoprodotto);
			        }
			       
			        // Aggiungi la combo box dei prodotti alla lista
			      //  prodottiBoxes.add(prodottoBox);

			        // Aggiungi la combo box alla GUI
			        addOrdFornPanel.add(prodottiBox);
			        addOrdFornPanel.add(quantita);
			        elementiForm.add(new Object[] {prodottiBox, quantita});
			        
			       
			        // Ridisegna la GUI
			        containerPanel.revalidate();
			        containerPanel.repaint();
				
			}
		});
		 containerPanel.add(addOrdFornPanel);
		 containerPanel.add(addMenuProdotto);
		 containerPanel.add(addButton);
		 
		 quantita.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                // Quando il campo di testo ottiene il focus, rimuovi il testo di placeholder se presente
	                if (quantita.getText().equals("Quantità")) {
	                    quantita.setText("");
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                // Quando il campo di testo perde il focus, se è vuoto, ripristina il testo di placeholder
	                if (quantita.getText().isEmpty()) {
	                	quantita.setText("Quantità");
	                }
	            }
	        });

	        // Imposta il testo di placeholder iniziale
	        quantita.setText("Quantità");
		 

	}
	
	
	
	public static void visualizzatoreOrdini() {
        JFrame vediOrdiniWindow = new JFrame("Visualizzazione Ordini");
        vediOrdiniWindow.setSize(700,500);
        vediOrdiniWindow.setLayout(new BorderLayout());
        vediOrdiniWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vediOrdiniWindow.setLocationRelativeTo(null);
        
        PNL_Label = new JPanel();
		PNL_Label.setLayout(new FlowLayout(FlowLayout.CENTER));
		PNL_table = new JPanel();
		PNL_table.setLayout(new FlowLayout(FlowLayout.CENTER));
		PNL_cerca = new JPanel();
		PNL_cerca.setLayout(new GridLayout(1,3,10,10));
		lBL_title = new JLabel("Elenco degli ordini");
		LBL_cerca = new JLabel("Inserisci l'id dell'ordine che vuoi visualizzare");
		TXF_cerca = new JTextField();
		addPlaceholder(TXF_cerca, "                     ");
		BTN_cerca = new JButton("Cerca");
		
		
        modello = new DefaultTableModel();
        JTable vediTable = new JTable(modello);
        String[] colonne = { "Id Ordine", "Id Fornitore", "Data Ordine", "Costo Totale", "Stato"};
        modello.setColumnIdentifiers(colonne);

        try {
            // Chiamata al tuo DAO per ottenere i dati dal database
            OrdiniFornitoreDAOImpl listaOrdForn= new OrdiniFornitoreDAOImpl();
            List<OrdiniFornitori> lista = listaOrdForn.showAllOrdForn(); 
           
            vediTable.setModel(modello);
            
            // Popolamento del modello con i dati dal database
            for (OrdiniFornitori ordforn : lista) {
                Object[] rowData = { ordforn.getId(), ordforn.getIdfornitore(), ordforn.getDataordine(), ordforn.getCostototale(),
                        ordforn.getStato()};
                modello.addRow(rowData);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vediOrdiniWindow, "Errore durante il recupero dei dati dal database", "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }
        vediTable.setModel(modello);
        

        JScrollPane scrollPane = new JScrollPane(vediTable);
        PNL_table.add(vediTable);
		PNL_Label.add(lBL_title);
		PNL_cerca.add(LBL_cerca);
		PNL_cerca.add(TXF_cerca);
		PNL_cerca.add(BTN_cerca);
        vediOrdiniWindow.add(scrollPane);
        vediOrdiniWindow.add(PNL_Label, BorderLayout.PAGE_START);
        vediOrdiniWindow.add(PNL_table, BorderLayout.CENTER);
        vediOrdiniWindow.add(PNL_cerca, BorderLayout.SOUTH);
        
        vediOrdiniWindow.setVisible(true);
        
        BTN_cerca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long idordine = Long.parseLong(TXF_cerca.getText());
				dettaglioOrdineId(idordine);
			}
		});
    }
	
	
	
	
	private static void dettaglioOrdineId(long idordine) {
		 JFrame vediOrdiniWindow = new JFrame("Visualizzazione Dettaglio Ordine");
	        vediOrdiniWindow.setSize(700,500);
	        vediOrdiniWindow.setLayout(new BorderLayout());
	        vediOrdiniWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vediOrdiniWindow.setLocationRelativeTo(null);
	        
	        PNL_Label = new JPanel();
			PNL_Label.setLayout(new FlowLayout(FlowLayout.CENTER));
			PNL_table = new JPanel();
			PNL_table.setLayout(new FlowLayout(FlowLayout.CENTER));
			lBL_title = new JLabel("Dettaglio dell'ordine selezionato");
			
			
	        modello = new DefaultTableModel();
	        JTable vediTable = new JTable(modello);
	        String[] colonne = { "Nome prodotto", "Descrizione", "Prezzo", "Quantità"};
	        modello.setColumnIdentifiers(colonne);
	        try {
	            // Chiamata al tuo DAO per ottenere i dati dal database
	            OrdiniFornitoreDAOImpl listaOrdForn= new OrdiniFornitoreDAOImpl();
	            List<Object[]> lista = listaOrdForn.showDettaglioOrdFornById(idordine); 
	            vediTable.setModel(modello);
	            // Popolamento del modello con i dati dal database
	            for (Object[] ordforn : lista) {
	                String nomeProdotto = (String) ordforn [0];
	                String descrizioneProdotto = (String) ordforn[1];
	                Double prezzoProdotto = (Double) ordforn[2];
	                Integer quantitaOrdine = (Integer) ordforn[3];
	                Object[] riga = {nomeProdotto, descrizioneProdotto, prezzoProdotto, quantitaOrdine};
	                modello.addRow(riga);
	               
	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(vediOrdiniWindow, "Errore durante il recupero dei dati dal database", "Errore",
	                    JOptionPane.ERROR_MESSAGE);
	        }
	        vediTable.setModel(modello);
	        

	        JScrollPane scrollPane = new JScrollPane(vediTable);
	        PNL_table.add(vediTable);
	        PNL_table.add(scrollPane, BorderLayout.CENTER);
			PNL_Label.add(lBL_title);
	        vediOrdiniWindow.add(scrollPane);
	        vediOrdiniWindow.add(PNL_Label, BorderLayout.PAGE_START);
	        vediOrdiniWindow.add(PNL_table, BorderLayout.CENTER);
	        
	        vediOrdiniWindow.setVisible(true);
	};
	
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
	
	private static void clearFields() {
		quantita.setText("");
		dataOrdine.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
