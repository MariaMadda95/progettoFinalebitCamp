package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ClientiView;
import view.DipendentiView;
import view.FornitoreView;
import view.MagazzinoView;
import view.OrdiniClientiView;
import view.OrdiniFornitoriView;
import view.ProdottiView;

public class Main extends JFrame implements ActionListener{
	
	
	private JButton Clienti, Dipendenti, Fornitori, Magazzino, Prodotti, Ordini , ordiniClienti, ordiniFornitori, ordinaDaFornitori, aggiungiFornitore, visualizzaFornitori;
	
	
	public Main() {
		setTitle("Pezzi Di Legno Gestionale");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(7, 2));
		
		Clienti = new JButton("Clienti");
		Dipendenti = new JButton("Gestione Dipendenti");
		Fornitori = new JButton("Gestione Fornitori");
		Magazzino = new JButton("Gestione Magazzino");
		Prodotti = new JButton("Prodotti");
		Ordini = new JButton("Visualizza Ordini");
		ordinaDaFornitori = new JButton("Ordina Prodotto da Fornitore");
		
		add(Clienti);
		add(Dipendenti);
		add(Fornitori);
		add(Magazzino);
		add(Prodotti);
		add(Ordini);
		add(ordinaDaFornitori);
		
		Clienti.addActionListener(this);
		Dipendenti.addActionListener(this);
		Fornitori.addActionListener(this);
		Magazzino.addActionListener(this);
		Prodotti.addActionListener(this);
		Ordini.addActionListener(this);
		ordinaDaFornitori.addActionListener(this);
		
		setVisible(true);
		
				
	}
	
	public void ordini()  {
		JFrame ordini = new JFrame("Ordini");
		JPanel ordiniPan = new JPanel(new GridLayout(8,2));
		ordiniClienti = new JButton("Ordini clienti");
		ordiniFornitori = new JButton("Ordini Fornitori");
		
		ordiniPan.add(ordiniClienti);
		ordiniPan.add(ordiniFornitori);
		
		
		ordiniClienti.addActionListener(this);
		ordiniFornitori.addActionListener(this);
		
		
		
		ordini.add(ordiniPan);
		ordini.setSize(600,400);
		ordini.setLocationRelativeTo(null);
		ordini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ordini.setVisible(true);
		
	}
	
	public void fornitori() {
		JFrame fornitori = new JFrame("Fornitori");
		JPanel fornitoriPan = new JPanel(new GridLayout(8,2));
		aggiungiFornitore = new JButton("Aggiungi Fornitore");
		visualizzaFornitori = new JButton("Visualizza Fornitori");
		
		fornitoriPan.add(aggiungiFornitore);
		fornitoriPan.add(visualizzaFornitori);
		
		
		aggiungiFornitore.addActionListener(this);
		visualizzaFornitori.addActionListener(this);
		
		
		
		fornitori.add(fornitoriPan);
		fornitori.setSize(600,400);
		fornitori.setLocationRelativeTo(null);
		fornitori.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		fornitori.setVisible(true);
	}
	

	
	public void actionPerformed(ActionEvent e)	{
		if (e.getSource() == Clienti) {
			new ClientiView();
		}else if(e.getSource() == Dipendenti) {
			new DipendentiView();
		}else if(e.getSource() == Fornitori) {
			fornitori();
		}else if(e.getSource() == Magazzino) {
			new MagazzinoView();
		}else if(e.getSource() == Prodotti) {
			new ProdottiView();
		}else if(e.getSource() == Ordini) {
			ordini();
		}else if(e.getSource() == ordiniClienti) {
			new OrdiniClientiView();
		}else if(e.getSource() == ordinaDaFornitori) {
			OrdiniFornitoriView.AddOrdForn();
		}else if(e.getSource() == aggiungiFornitore) {
			FornitoreView.AddFornitore();
		}else if(e.getSource() == visualizzaFornitori) {
			FornitoreView.ViewFornitori();
		}else if(e.getSource() == ordiniFornitori) {
			OrdiniFornitoriView.visualizzatoreOrdini();
		}
		
	}
	
	

	public static void main(String[] args) {
		new Main();

	}

}
