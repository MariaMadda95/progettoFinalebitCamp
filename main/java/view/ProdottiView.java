package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProdottiDAOImpl;


public class ProdottiView extends JFrame implements ActionListener{
	
	//definiamo i campi che ci serviranno per l'interfaccia grafica (per inserire i valori)
		 private JTextField nomeField, descrizioneField, linkFotoField, materialeField, repartoField, prezzoField;
		 private JButton inviaButton, modificaButton;
		 private JLabel messaggioLabel;
		 
		 
		 public ProdottiView() {
			 //definiamo le proprietà della finestra, comed eve essere visualizzata 
			 setTitle("Form Prodotti ");
			 setSize(600, 400); 
			 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			 setLocationRelativeTo(null);
			 
			 JPanel panel = new JPanel(); 
			 panel.setLayout(new GridLayout(8,2)); // 5 righe e 2 colonne 
		 
	
	 //creiamo gli oggetti della finestra 
	 JLabel nomeLabel = new JLabel("Nome: ");
	 nomeField = new JTextField(); //istanza
	 JLabel descrizioneLabel = new JLabel("Descrizione: ");
	 descrizioneField = new JTextField();
	 JLabel linkFotoLabel = new JLabel("LinkFoto: ");
	 linkFotoField = new JTextField();
	 JLabel materialeLabel = new JLabel("Materiale: ");
	 materialeField = new JTextField();
	 JLabel repartoLabel = new JLabel("Reparto: ");
	 repartoField = new JTextField();
	 JLabel prezzoLabel = new JLabel("Prezzo: ");
	 prezzoField = new JTextField();
	 
	 
	 //associamo gli oggetti ad uno dei pannelli della nostra fienstra, inq uesto caso ne abbiamo una, il Panel
	 panel.add(nomeLabel);
	 panel.add(nomeField);
	 panel.add(descrizioneLabel);
	 panel.add(descrizioneField);
	 panel.add(linkFotoLabel);
	 panel.add(linkFotoField);
	 panel.add(materialeLabel);
	 panel.add(materialeField);
	 panel.add(repartoLabel);
	 panel.add(repartoField);
	 panel.add(prezzoLabel);
	 panel.add(prezzoField);
	 
	//creare il bottone
	 inviaButton= new JButton("Invia");
	 inviaButton.addActionListener(this);
	 
	 modificaButton = new JButton("Modifica");
     modificaButton.addActionListener(this);
     panel.add(modificaButton);
	 
	 
	 messaggioLabel = new JLabel();
	 
	 //inserimento nel Panel di bottone e Label con messaggio
	 panel.add(inviaButton);
	 panel.add(messaggioLabel);
	 
	 //inserire iol pannello stesso all'interno del JFrame
	 add(panel);
	 setVisible(true);
 }

		 
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == inviaButton) {
			 String nome = nomeField.getText();
			 String descrizione = descrizioneField.getText();
			 String linkFoto = linkFotoField.getText();
			 String materiale = materialeField.getText();
			 String reparto = materialeField.getText();
			 String prezzo = prezzoField.getText();
			 double prezzoD = Double.parseDouble(prezzo);
	 
			// messaggio da far visualizzare 
			 String messaggio = "Grazie per aver inviato i dati:\nNome: " + nome + "\ndescrizione: " + descrizione + "\nlinkFoto: " + linkFoto + "\nMateriale: " + materiale + "\nMReparto: " + reparto + "\nPrezzo: " + prezzo;
		
			 ProdottiDAOImpl Prodotto1 = new ProdottiDAOImpl();
			
			 Prodotto1.addProdotti(nome, descrizione, linkFoto, materiale, reparto, prezzoD);
			 
			 JOptionPane.showMessageDialog(this, "Nuovo prodotto inserito!");
			 
			} else if (e.getSource() == modificaButton) {
				
	            modificaProdotti();
	        }
			 messaggioLabel.setText("Prodotto modificato correttamente");
		   }


		private void modificaProdotti() {
		        String nome = nomeField.getText();
		        String descrizione = descrizioneField.getText();
		        String linkFoto = linkFotoField.getText();
		        String materiale = materialeField.getText();
		        String reparto = materialeField.getText(); // Corretto da repartoField.getText()
		        String prezzo = prezzoField.getText();
		        double prezzoD = Double.parseDouble(prezzo);

		        // messaggio da far visualizzare
		        String messaggio = "Dati modificati:\nNome: " + nome + "\nDescrizione: " + descrizione + "\nLinkFoto: "
		                + linkFoto + "\nMateriale: " + materiale + "\nReparto: " + reparto + "\nPrezzo: " + prezzo;

		        // Chiamata al metodo di modifica nel controller
		        ProdottiDAOImpl prodottoDAO = new ProdottiDAOImpl();
		        prodottoDAO.modificaProdotti(nome, descrizione, linkFoto, materiale, reparto, prezzoD);

		        JOptionPane.showMessageDialog(this, "Prodotto modificato!");
		        messaggioLabel.setText(messaggio);
		    }
			
		}
			
