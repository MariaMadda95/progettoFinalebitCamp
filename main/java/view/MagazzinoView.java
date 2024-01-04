package view;

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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.MagazzinoDAOImpl;
import model.Magazzino;

public class MagazzinoView extends JFrame implements ActionListener {

	// definiamo i campi che ci serviranno per l'interfaccia grafica (per inserire i
	// valori)
	MagazzinoDAOImpl mag = new MagazzinoDAOImpl();
	private JTextField idProdottoField, disponibilitaField;
	private JButton inviaButton, aggiungiProdottoBTN, modificaProdottoBTN, refresh;
	private JLabel messaggioLabel;
	private DefaultTableModel modello = new DefaultTableModel();
	JTable magTabella = new JTable(modello);
	public MagazzinoView() {
		// definiamo le proprietà della finestra, comed eve essere visualizzata
		aggiungiProdottoBTN = new JButton("Aggiungi Prodotto");
		modificaProdottoBTN = new JButton("Modifica Prodotto");
		refresh = new JButton("Refresh Page");
		
		setTitle("Gestione Magazzino ");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 2));
		
		
		
		String[] colonne = { "id", "Nome", "Disponibilità" };
		modello.setColumnIdentifiers(colonne);

		try {
			
			List<Magazzino> lista = mag.vediMagazzino();
			magTabella.setModel(modello);
			for (Magazzino mag1 : lista) {
				Object[] rowData = { mag1.getId(), mag1.getNomeProdotto(), mag1.getDisponibilita() };
				modello.addRow(rowData);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Errore durante il recupero dei dati dal database", "Errore",
					JOptionPane.ERROR_MESSAGE);
		}

		JScrollPane scrollPane = new JScrollPane(magTabella);

		add(scrollPane);
		add(aggiungiProdottoBTN);
		add(modificaProdottoBTN);
		add(refresh);
		setVisible(true);

		aggiungiProdottoBTN.addActionListener(this);
		modificaProdottoBTN.addActionListener(this);
		refresh.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == inviaButton) {
			MagazzinoDAOImpl magImpl = new MagazzinoDAOImpl();
			String idProdotto = idProdottoField.getText();
			long idP = Long.parseLong(idProdotto);
			String dispponibilita = disponibilitaField.getText();
			int dis = Integer.parseInt(dispponibilita);
			String messaggio = "Grazie per aver inviato i dati:\nidProdotto: " + idProdotto + "\ndisponibilita: "
					+ dispponibilita;
			messaggioLabel.setText(messaggio);
			magImpl.addProdottiInMag(idP, dis);
			
		} else if (e.getSource() == aggiungiProdottoBTN) {
			
			JFrame panel = new JFrame("Aggiungi Prodotti");
			JPanel panelPan = new JPanel(new GridLayout(3,2));
			panel.setSize(600,400);
			panel.setLocationRelativeTo(null);
			panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			JLabel idProdottoLabel = new JLabel("idProdotto: ");
			idProdottoField = new JTextField();
			JLabel disponibilitaLabel = new JLabel("Disponibilita: ");
			disponibilitaField = new JTextField();

			panelPan.add(idProdottoLabel);
			panelPan.add(idProdottoField);
			panelPan.add(disponibilitaLabel);
			panelPan.add(disponibilitaField);

			// creare il bottone
			inviaButton = new JButton("Invia");
			inviaButton.addActionListener(this);

			messaggioLabel = new JLabel();

			// inserimento nel Panel di bottone e Label con messaggio
			panelPan.add(inviaButton);
			panelPan.add(messaggioLabel);
			panel.add(panelPan);
			panel.setVisible(true);
			
		}else if(e.getSource() == refresh) {
			
			try {
				List<Magazzino> lista = mag.vediMagazzino();
				magTabella.setModel(modello);
				for (Magazzino mag1 : lista) {
					Object[] rowData = { mag1.getId(), mag1.getNomeProdotto(), mag1.getDisponibilita() };
					modello.addRow(rowData);
				}

			} catch (Exception ef) {
				ef.printStackTrace();
				JOptionPane.showMessageDialog(this, "Errore durante il recupero dei dati dal database", "Errore",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}
