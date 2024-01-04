package view;

import javax.swing.*;

import controller.DipendentiDAOimpl;
import controller.OreLavorateDAOimpl;
import model.Dipendenti;
import model.DipendentiDAO;
import model.OreLavorate;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DipendentiView extends JFrame{
	private JLabel idLabel, idOreLabel, cognomenomeLabel, telefonoLabel, mailLabel, passwordLabel, idruoloLabel, dataassunzioneLabel, costoorarioLabel, iddipendenteLabel, meseLabel, orenormaliLabel, orestraordinarieLabel, oretotaliLabel;
	private JTextField idField, idOreField, cognomenomeField, telefonoField, mailField, passwordField, idruoloField, dataassunzioneField, costoorarioField, iddipendenteField, meseField, orenormaliField, orestraordinarieField, oretotaliField;
	private JButton salvaButton, modificaButton, refreshButton, selectButton, salvaOreButton, modificaOreButton, refreshOreButton, selectOreButton;
	private JTable elencoTbl;
	private JComboBox<String> dipendentiBox;
	
    // Creazione delle voci di menu
    JButton inserisciMenu = new JButton("Inserisci");
    JButton modificaMenu = new JButton("Modifica");
    JButton visualizzaMenu = new JButton("Visualizza");
    JButton registroOreMenu = new JButton("Registro Ore");
    
    DipendentiDAOimpl dDAO = new DipendentiDAOimpl();
    OreLavorateDAOimpl oreDAO = new OreLavorateDAOimpl();
    
    public DipendentiView() {
    	setTitle("Dipendenti");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        idLabel = new JLabel("Inserisci l'ID del dipendente da modificare");
		idField = new JTextField(5);
		idOreLabel = new JLabel("Inserisci l'ID della registrazione da modificare");
		idOreField = new JTextField(5);
		cognomenomeLabel = new JLabel("Cognome e nome:");
		telefonoLabel = new JLabel("Telefono:");
		mailLabel = new JLabel("Mail:");
		passwordLabel = new JLabel("Password:");
		idruoloLabel = new JLabel("Id ruolo:");
		dataassunzioneLabel = new JLabel("Data assunzione (formato aaaa-mm-gg):");
		costoorarioLabel = new JLabel("Costo orario:");
		iddipendenteLabel = new JLabel("Seleziona il dipendente:");
		meseLabel = new JLabel("Mese:");
		orenormaliLabel = new JLabel("Ore ordinarie:");
		orestraordinarieLabel = new JLabel("Ore straordinarie:"); 
		oretotaliLabel = new JLabel("Ore totali:");
		cognomenomeField = new JTextField(255);
		telefonoField = new JTextField(15);
		mailField = new JTextField(255);
		passwordField = new JTextField(255);
		idruoloField = new JTextField(10);
		dataassunzioneField = new JTextField(10);
		costoorarioField = new JTextField(5);
		//iddipendenteField = new JTextField(15);
		dipendentiBox = new JComboBox<>();
		//ArrayList<Long> listaIDdip = new ArrayList<>();
		List<Dipendenti> listaDip = dDAO.getAllDipendenti();
		// ciclo che aggiunge una voce per ogni fornitore presente nel database
		for(Dipendenti d:listaDip) {
			long iddipendente = d.getId();
			String nomeDipendente = d.getNome();
			String id = Long.toString(iddipendente);
			dipendentiBox.addItem(id + "-" + nomeDipendente);
			//listaIDdip.add(iddipendente);
			
		}
		
		meseField = new JTextField(15);
		orenormaliField  = new JTextField(15);
		orestraordinarieField = new JTextField(15);
		oretotaliField = new JTextField(15);
		salvaButton = new JButton("Salva");
		modificaButton = new JButton("Modifica");
		refreshButton = new JButton("Aggiorna elenco");
		selectButton = new JButton("Seleziona");
		salvaOreButton = new JButton("Salva");
		modificaOreButton = new JButton("Modifica");
		refreshOreButton = new JButton("Aggiorna elenco");
		selectOreButton = new JButton("Seleziona");
        
        // Creazione del pannello principale
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,1,10,10));
        
        // Aggiunta degli action listener ai bottoni
        inserisciMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 1
                //mainPanel.removeAll();
                //mainPanel.add(new DipendentiViewInserimento(), BorderLayout.CENTER);
                //mainPanel.revalidate();
                //mainPanel.repaint();
            	DipendentiViewInserimento();
            }
        });

        modificaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 2
//                mainPanel.removeAll();
//                mainPanel.add(new JLabel("Contenuto Funzione 2"), BorderLayout.CENTER);
//                mainPanel.revalidate();
//                mainPanel.repaint();
            	DipendentiViewModifica();
            }
        });
        
        visualizzaMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 1
//                mainPanel.removeAll();
//                mainPanel.add(new JLabel("Contenuto Funzione 1"), BorderLayout.CENTER);
//                mainPanel.revalidate();
//                mainPanel.repaint();
            	DipendentiViewVisualizza();
            }
        });

        registroOreMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 2
//                mainPanel.removeAll();
//                mainPanel.add(new JLabel("Contenuto Funzione 2"), BorderLayout.CENTER);
//                mainPanel.revalidate();
//                mainPanel.repaint();
            	oreLavorateViewMain();
            }
        });
        
        // Aggiunta delli bottoni al panel
        mainPanel.add(inserisciMenu);
        mainPanel.add(modificaMenu);
        mainPanel.add(visualizzaMenu);
        mainPanel.add(registroOreMenu);
        
        
        // Aggiunta del pannello principale al frame
        add(mainPanel);

        // Impostazione della visibilità del frame
        setVisible(true);
        
    }
    
    public void DipendentiViewInserimento() {
    	JFrame jFadd = new JFrame();
    	jFadd.setTitle("Inserisci Dipendenti");
    	jFadd.setSize(600,400); 
    	jFadd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    	jFadd.setLocationRelativeTo(null);
    	
    	JPanel panel = new JPanel(new GridLayout(8,2,10,10));
		
		panel.add(cognomenomeLabel);
		panel.add(cognomenomeField);
		panel.add(telefonoLabel);
		panel.add(telefonoField);
		panel.add(mailLabel);
		panel.add(mailField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(idruoloLabel);
		panel.add(idruoloField);
		panel.add(dataassunzioneLabel);
		//panel.add(datePicker);
		panel.add(dataassunzioneField);
		panel.add(costoorarioLabel);
		panel.add(costoorarioField);
		panel.add(new JLabel(""));
		panel.add(salvaButton);
		
		salvaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = cognomenomeField.getText();
				String telefono = telefonoField.getText();
				String mail = mailField.getText();
				String password = passwordField.getText();
				long idruolo = Long.parseLong(idruoloField.getText());
				String dataassunzione = dataassunzioneField.getText();
				double costoorario = Double.parseDouble(costoorarioField.getText().replace(",", "."));
				Dipendenti d = new Dipendenti();
				d.setNome(nome);
				d.setTelefono(telefono);
				d.setMail(mail);
				d.setPassword(password);
				d.setIdruolo(idruolo);
				d.setDataassunzione(dataassunzione);
				d.setCostoorario(costoorario);
				dDAO.save(d);
				
				JOptionPane.showMessageDialog(salvaButton, "Dipendente inserito");
				
				cognomenomeField.setText("");
				telefonoField.setText("");
				mailField.setText("");
				passwordField.setText("");
				idruoloField.setText("");
				dataassunzioneField.setText("");
				costoorarioField.setText("");
				
				
			}
			
		});
		
		jFadd.add(panel);
		jFadd.setVisible(true);
    }
    
    public void DipendentiViewModifica() {
    	JFrame jFedit = new JFrame();
    	jFedit.setTitle("Modifica Dipendenti");
    	jFedit.setSize(600,400);
    	jFedit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	jFedit.setLocationRelativeTo(null);
    	

		JPanel elenco = new JPanel();
		elencoTbl = new JTable();
		dDAO.visualizzaElenco(elencoTbl);

		// Aggiunta di uno JScrollPane alla tabella per visualizzare le intestazioni delle colonne
		JScrollPane scrollPane = new JScrollPane(elenco);
		
		JPanel select = new JPanel(new GridLayout(1, 2));
		select.add(idLabel);
		select.add(idField);
		select.add(selectButton);
		
		JPanel modifica = new JPanel(new GridLayout(8, 2, 10, 10));

		modifica.add(cognomenomeLabel);
		modifica.add(cognomenomeField);
		modifica.add(telefonoLabel);
		modifica.add(telefonoField);
		modifica.add(mailLabel);
		modifica.add(mailField);
		modifica.add(passwordLabel);
		modifica.add(passwordField);
		modifica.add(idruoloLabel);
		modifica.add(idruoloField);
		modifica.add(dataassunzioneLabel);
		modifica.add(dataassunzioneField);
		modifica.add(costoorarioLabel);
		modifica.add(costoorarioField);
		modifica.add(modificaButton);
		modifica.add(refreshButton);
		
		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(idField.getText());
				Dipendenti dip = dDAO.getDipendentiById(id);

				cognomenomeField.setText(dip.getNome());
				telefonoField.setText(dip.getTelefono());
				mailField.setText(dip.getMail());
				passwordField.setText(dip.getPassword());
				idruoloField.setText(Long.toString(dip.getIdruolo()));
				dataassunzioneField.setText(dip.getDataassunzione());
				costoorarioField.setText(Double.toString(dip.getCostoorario()));

			}
		});

		modificaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(idField.getText());
				Dipendenti d = dDAO.getDipendentiById(id);
				String nome = cognomenomeField.getText();
				String telefono = telefonoField.getText();
				String mail = mailField.getText();
				String password = passwordField.getText();
				long idruolo = Long.parseLong(idruoloField.getText());
				String dataassunzione = dataassunzioneField.getText();
				double costoorario = Double.parseDouble(costoorarioField.getText().replace(",", "."));

				d.setNome(nome);
				d.setTelefono(telefono);
				d.setMail(mail);
				d.setPassword(password);
				d.setIdruolo(idruolo);
				d.setDataassunzione(dataassunzione);
				d.setCostoorario(costoorario);
				dDAO.update(d);

				idField.setText("");
				cognomenomeField.setText("");
				telefonoField.setText("");
				mailField.setText("");
				passwordField.setText("");
				idruoloField.setText("");
				dataassunzioneField.setText("");
				costoorarioField.setText("");

			}
		});

		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aggiornamento delle tabelle
				dDAO.visualizzaElenco(elencoTbl);
			}
		});
		
		elenco.add(elencoTbl);
		jFedit.add(scrollPane, BorderLayout.CENTER); // forse così non funziona

		jFedit.add(elenco, BorderLayout.NORTH);
		jFedit.add(select, BorderLayout.CENTER);
		jFedit.add(modifica, BorderLayout.SOUTH);
		jFedit.setVisible(true);
    }
    
    public void DipendentiViewVisualizza() {
    	JFrame jFview = new JFrame();
    	jFview.setTitle("Elenco Dipendenti");
    	jFview.setSize(600, 400);
    	jFview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	jFview.setLocationRelativeTo(null);
    	
    	JPanel elenco = new JPanel();
		elencoTbl = new JTable();
		dDAO.visualizzaElenco(elencoTbl);
		
		JScrollPane scrollPane = new JScrollPane(elenco);
		
		elenco.add(elencoTbl);
		jFview.add(scrollPane);
		jFview.add(elenco);
		jFview.setVisible(true);
    }
    
    public void oreLavorateViewMain() {
    	JFrame jFOreView = new JFrame();
    	jFOreView.setTitle("Ore lavorate");
    	jFOreView.setSize(600, 400);
    	jFOreView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	jFOreView.setLocationRelativeTo(null);
    	JButton inserisci = new JButton("Inserisci ore");
    	JButton modifica = new JButton("Modifica ore");
    	JButton visualizza = new JButton("Visualizza ore");
    	
    	final JPanel mainOrePanel = new JPanel();
        mainOrePanel.setLayout(new GridLayout(3,1,10,10));
        
        mainOrePanel.add(inserisci);
        mainOrePanel.add(modifica);
        mainOrePanel.add(visualizza);
        
        inserisci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 1
                //mainPanel.removeAll();
                //mainPanel.add(new DipendentiViewInserimento(), BorderLayout.CENTER);
                //mainPanel.revalidate();
                //mainPanel.repaint();
            	oreInserimento();
            }
        });

        modifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 2
//                mainPanel.removeAll();
//                mainPanel.add(new JLabel("Contenuto Funzione 2"), BorderLayout.CENTER);
//                mainPanel.revalidate();
//                mainPanel.repaint();
            	oreModifica();
            }
        });
        
        visualizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sostituisci il contenuto del pannello principale con il nuovo contenuto per Funzione 1
//                mainPanel.removeAll();
//                mainPanel.add(new JLabel("Contenuto Funzione 1"), BorderLayout.CENTER);
//                mainPanel.revalidate();
//                mainPanel.repaint();
            	oreVisualizza();
            }
        });
        
        jFOreView.add(mainOrePanel);
        jFOreView.setVisible(true);
        
    }
    
    public void oreInserimento() {
    	JFrame jForeAdd = new JFrame();
    	
    	jForeAdd.setTitle("Inserisci Ore lavorate");
    	jForeAdd.setSize(800,600); 
    	jForeAdd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    	jForeAdd.setLocationRelativeTo(null);
    	
    	JPanel panel = new JPanel(new GridLayout(5,2,10,10));
    	
    	panel.add(iddipendenteLabel);
		panel.add(dipendentiBox);
		panel.add(meseLabel);
		panel.add(meseField);
		panel.add(orenormaliLabel);
		panel.add(orenormaliField);
		panel.add(orestraordinarieLabel);
		panel.add(orestraordinarieField);
		panel.add(new JLabel(""));
		panel.add(salvaOreButton);
		
		salvaOreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long iddipendente = dipendentiBox.getSelectedIndex() + 1;
				String mese = meseField.getText();
				int orenormali = Integer.parseInt(orenormaliField.getText());
				int orestraordinarie = Integer.parseInt(orestraordinarieField.getText());
				int oretotali = orenormali + orestraordinarie;
				OreLavorate ol = new OreLavorate();
				ol.setIddipendente(iddipendente);
				ol.setMese(mese);
				ol.setOrenormali(orenormali);
				ol.setOrestraordinarie(orestraordinarie);
				ol.setOretotali(oretotali);
				oreDAO.save(ol);
				
				meseField.setText("");
				orenormaliField.setText("");
				orestraordinarieField.setText("");
				
				
				
			}
			
		});
		
		jForeAdd.add(panel);
		jForeAdd.setVisible(true);
    	
    }
    
    public void oreModifica() {
    	JFrame jForeEdit = new JFrame();
    	jForeEdit.setTitle("Modifica Registro Ore");
    	jForeEdit.setSize(600, 400);
    	jForeEdit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	jForeEdit.setLocationRelativeTo(null);
    	
    	JPanel elenco = new JPanel();
		elencoTbl = new JTable();
		oreDAO.visualizzaElencoOre(elencoTbl);
		
		// Aggiunta di uno JScrollPane alla tabella per visualizzare le intestazioni delle colonne
		JScrollPane scrollPane = new JScrollPane(elenco);
		
		JPanel select = new JPanel(new GridLayout(1, 2));
		//select.setSize(700, 10);
		select.add(idOreLabel);
		select.add(idOreField);
		select.add(selectOreButton);
		
		JPanel modifica = new JPanel(new GridLayout(5, 2, 10, 10));
		
		modifica.add(iddipendenteLabel);
		modifica.add(dipendentiBox);
		modifica.add(meseLabel);
		modifica.add(meseField);
		modifica.add(orenormaliLabel);
		modifica.add(orenormaliField);
		modifica.add(orestraordinarieLabel);
		modifica.add(orestraordinarieField);
		modifica.add(modificaOreButton);
		modifica.add(refreshOreButton);
		
		selectOreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(idOreField.getText());
				OreLavorate o = oreDAO.getOreLavorateById(id);
				dipendentiBox.setSelectedIndex((int)id-1);
				//posso far visualizzare il nome di interesse della combobox?
				
				meseField.setText(o.getMese());
				orenormaliField.setText(Integer.toString(o.getOrenormali()));
				orestraordinarieField.setText(Integer.toString(o.getOrestraordinarie()));
				
			}
		});
		
		modificaOreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = Long.parseLong(idOreField.getText());
				OreLavorate o = oreDAO.getOreLavorateById(id);
				
				long iddipendente = dipendentiBox.getSelectedIndex() + 1;
				String mese = meseField.getText();
				int orenormali = Integer.parseInt(orenormaliField.getText());
				int orestraordinarie = Integer.parseInt(orestraordinarieField.getText());
				int oretotali = orenormali + orestraordinarie;
				
				o.setIddipendente(iddipendente);
				o.setMese(mese);
				o.setOrenormali(orenormali);
				o.setOrestraordinarie(orestraordinarie);
				o.setOretotali(oretotali);
				oreDAO.update(o);
				
				meseField.setText("");
				orenormaliField.setText("");
				orestraordinarieField.setText("");

			}
		});
		
		refreshOreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aggiornamento delle tabelle
				oreDAO.visualizzaElencoOre(elencoTbl);
			}
		});
		
		elenco.add(elencoTbl);
		jForeEdit.add(scrollPane, BorderLayout.CENTER); // forse così non funziona

		jForeEdit.add(elenco, BorderLayout.NORTH);
		jForeEdit.add(select, BorderLayout.CENTER);
		jForeEdit.add(modifica, BorderLayout.SOUTH);
		jForeEdit.setVisible(true);
    }
    
    public void oreVisualizza() {
    	JFrame jForeView = new JFrame();
    	jForeView.setTitle("Visualizza Ore Registrate");
    	jForeView.setSize(600, 400);
    	jForeView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	jForeView.setLocationRelativeTo(null);
    	
    	JPanel elenco = new JPanel();
		elencoTbl = new JTable();
		oreDAO.visualizzaElencoOre(elencoTbl);
		
		JScrollPane scrollPane = new JScrollPane(elenco);
		
		elenco.add(elencoTbl);
		jForeView.add(scrollPane);
		jForeView.add(elenco);
		jForeView.setVisible(true);
    }
    
//   public static void main(String[] args) {
// 	    new DipendentiViewMain();
//    }
    
}
