package view;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ClientiDAOimpl;
import model.Clienti;
import java.util.List;
import java.awt.*;
import java.awt.event.*;


public class ClientiView extends JFrame implements ActionListener {
	//creato bottoni e campi da utilizzare 
	private JLabel nomeLabel, viaLabel, civicoLabel, cittaLabel, telefonoLabel, emailLabel, passwordLabel;
	private JTextField nomeField, viaField, civicoField, cittaField, telefonoField, emailField, passwordField;
	private JButton salvaButton, visualizzaButton, aggiungiButton;
	private DefaultTableModel modello;
	
	//costruttore della classe che estende il JFrame
	public ClientiView() {
		setTitle("Clienti");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(8, 2));
		
		aggiungiButton = new JButton("Aggiungi Clienti");
		visualizzaButton = new JButton("Visualizza");
		//azione del pulsante aggiugi clienti
		add(aggiungiButton);
		aggiungiButton.addActionListener(this);
		
		add(visualizzaButton);
		visualizzaButton.addActionListener(this);
		setVisible(true);
	}
	

	public void ClientiAggiungi() {
		JFrame addClientiWindow = new JFrame("Aggiungi Clienti");
		JPanel addPanel = new JPanel(new GridLayout(8, 2));

		nomeLabel = new JLabel("Inserisci nome");
		viaLabel = new JLabel("Inserisci via");
		civicoLabel = new JLabel("Inserisci civico");
		cittaLabel = new JLabel("Inserisci citta");
		telefonoLabel = new JLabel("Inserisci telefono");
		emailLabel = new JLabel("Inserisci email");
		passwordLabel = new JLabel("Inserisci password");

		nomeField = new JTextField();
		viaField = new JTextField();
		civicoField = new JTextField();
		cittaField = new JTextField();
		telefonoField = new JTextField();
		emailField = new JTextField();
		passwordField = new JTextField();

		salvaButton = new JButton("Inserisci");
		
		addPanel.add(nomeLabel);
		addPanel.add(nomeField);
		addPanel.add(viaLabel);
		addPanel.add(viaField);
		addPanel.add(civicoLabel);
		addPanel.add(civicoField);
		addPanel.add(cittaLabel);
		addPanel.add(cittaField);
		addPanel.add(telefonoLabel);
		addPanel.add(telefonoField);
		addPanel.add(emailLabel);
		addPanel.add(emailField);
		addPanel.add(passwordLabel);
		addPanel.add(passwordField);
		addPanel.add(salvaButton);

		salvaButton.addActionListener(this);
		

		addClientiWindow.add(addPanel);

		addClientiWindow.setSize(600, 400);
		addClientiWindow.setLocationRelativeTo(null);
		addClientiWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//addClientiWindow.setLayout(new GridLayout(8, 2));
		addClientiWindow.setVisible(true);

	}
	
	
	public void visualizzatore() {
		JFrame vediClientiWindow = new JFrame("Visualizzazione Clienti");
        modello = new DefaultTableModel();
        JTable vediTable = new JTable(modello);
        String[] colonne = { "Nome", "via", "Civico", "Città", "Telefono", "Mail", "Password" };
        modello.setColumnIdentifiers(colonne);

        try {
            // Chiamata al tuo DAO per ottenere i dati dal database
            ClientiDAOimpl listaClienti = new ClientiDAOimpl();
            List<Clienti> lista = listaClienti.mostraClienti(); 
            vediTable.setModel(modello);
            // Popolamento del modello con i dati dal database
            for (Clienti cliente : lista) {
                Object[] rowData = { cliente.getNome(), cliente.getVia(), cliente.getCivico(), cliente.getCitta(),
                        cliente.getTelefono(), cliente.getMail(), cliente.getPassword() };
                modello.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore durante il recupero dei dati dal database", "Errore",
                    JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(vediTable);
        vediClientiWindow.add(scrollPane);
        vediClientiWindow.setSize(800, 600);
        vediClientiWindow.setLocationRelativeTo(null);
        vediClientiWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vediClientiWindow.setVisible(true);
	}

	
	
	
	public void actionPerformed(ActionEvent e) {
		ClientiDAOimpl nuovoCliente = new ClientiDAOimpl();
		ClientiDAOimpl listaClienti = new ClientiDAOimpl();

		if (e.getSource() == aggiungiButton) {
			ClientiAggiungi();

		} else if (e.getSource() == salvaButton) {
			String nome = nomeField.getText();
			String via = viaField.getText();
			String civico = civicoField.getText();
			String citta = cittaField.getText();
			String telefono = telefonoField.getText();
			String email = emailField.getText();
			String password = passwordField.getText();

			nuovoCliente.addCliente(nome, via, civico, citta, telefono, email, password);
			JOptionPane.showMessageDialog(this, "nuovo cliente inserito");

		} else if (e.getSource() == visualizzaButton) {
			visualizzatore();

		}

	}
}
