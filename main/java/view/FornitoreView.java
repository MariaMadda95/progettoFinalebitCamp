package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import controller.FornitoreDAOImpl;
import controller.OrdiniFornitoreDAOImpl;
import model.Fornitore;
import model.OrdiniFornitori;

public class FornitoreView extends JFrame implements ActionListener {
	private static JTextField nomeField;
	private static JTextField telefonoField;
	private static JTextField mailField;
	private static JTextField referenteField;
	private static DefaultTableModel modello;

	public static void AddFornitore() {
		JFrame aggiungiFornitoriFrame = new JFrame("Aggiungi un fornitore");
		aggiungiFornitoriFrame.setSize(700, 500);
		aggiungiFornitoriFrame.setLayout(new BorderLayout());
		aggiungiFornitoriFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aggiungiFornitoriFrame.setLocationRelativeTo(null);

		JPanel addFornitorePanel = new JPanel();
		addFornitorePanel.setLayout(new GridLayout(5, 2));
		// Campi di testo per nome, telefono, email e referente
		addFornitorePanel.add(new JLabel("Nome:"));
		nomeField = new JTextField();
		addFornitorePanel.add(nomeField);

		addFornitorePanel.add(new JLabel("Telefono:"));
		telefonoField = new JTextField();
		addFornitorePanel.add(telefonoField);

		addFornitorePanel.add(new JLabel("Email:"));
		mailField = new JTextField();
		addFornitorePanel.add(mailField);

		addFornitorePanel.add(new JLabel("Referente:"));
		referenteField = new JTextField();
		addFornitorePanel.add(referenteField);

		// Pulsante per l'azione di aggiunta
		JButton addButton = new JButton("Aggiungi");
		addFornitorePanel.add(addButton);

		aggiungiFornitoriFrame.add(addFornitorePanel);
		aggiungiFornitoriFrame.setVisible(true);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FornitoreDAOImpl nuovoFornitore = new FornitoreDAOImpl();
				// Esempio: ottenere i valori dai campi di testo
				String nome = nomeField.getText();
				String telefono = telefonoField.getText();
				String mail = mailField.getText();
				String referente = referenteField.getText();

				nuovoFornitore.addFornitore(nome, telefono, mail, referente);

				clearFields();
			}
		});

	}

	public static void ViewFornitori() {
		JFrame vediFornitoriWindow = new JFrame("Visualizzazione Fornitori");
		modello = new DefaultTableModel();
		JTable vediTable = new JTable(modello);
		String[] colonne = {"Nome", "Telefono", "Mail", "Referente"};
		modello.setColumnIdentifiers(colonne);

		try {
			// Chiamata al tuo DAO per ottenere i dati dal database
			FornitoreDAOImpl listaFornitori = new FornitoreDAOImpl();
			List<Fornitore> lista = listaFornitori.showAllFornitori();
			vediTable.setModel(modello);
			// Popolamento del modello con i dati dal database
			for (Fornitore fornitore : lista) {
				Object[] rowData = { fornitore.getNome(), fornitore.getTelefono(), fornitore.getMail(), fornitore.getReferente() };
				modello.addRow(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(vediFornitoriWindow, "Errore durante il recupero dei dati dal database", "Errore",
					JOptionPane.ERROR_MESSAGE);
		}

		JScrollPane scrollPane = new JScrollPane(vediTable);
		vediFornitoriWindow.add(scrollPane);
		vediFornitoriWindow.setSize(800, 600);
		vediFornitoriWindow.setLocationRelativeTo(null);
		vediFornitoriWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vediFornitoriWindow.setVisible(true);
	}

	private static void clearFields() {
		nomeField.setText("");
		telefonoField.setText("");
		mailField.setText("");
		referenteField.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
