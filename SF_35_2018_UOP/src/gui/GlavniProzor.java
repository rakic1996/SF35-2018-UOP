package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.FormeZaPrikaz.DispeceriProzor;
import osobe.Dispecer;
import taxi_sluzba.Taxi_sluzba;



public class GlavniProzor extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu dispecerMenu = new JMenu("Dispeceri");
	private JMenuItem diskoviItem = new JMenuItem("Diskovi");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem kompozicijeItem = new JMenuItem("Kompozicije");
	private JMenu prodavciMenu = new JMenu("Prodavci");
	private JMenuItem prodavciItem = new JMenuItem("Prodavci");
	
	private Taxi_sluzba taxi_sluzba;
	private Dispecer prijavljeniKorisnik;
	
	public GlavniProzor(Taxi_sluzba taxi_sluzba, Dispecer prijavljeniKorisnik) {
		this.taxi_sluzba = taxi_sluzba;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Prodavac: " + prijavljeniKorisnik.getKorIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
//		initMenu();
//		initActions();
	}
	
//	private void initMenu() {
//		setJMenuBar(mainMenu);
//		mainMenu.add(artikliMenu);
//		artikliMenu.add(diskoviItem);
//		artikliMenu.add(knjigeItem);
//		artikliMenu.add(kompozicijeItem);
//		mainMenu.add(prodavciMenu);
//		prodavciMenu.add(prodavciItem);
//	}
//	
//	private void initActions() {
//		prodavciItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DispeceriProzor dp = new DispeceriProzor(taxi_sluzba);
//				dp.setVisible(true);
//			}
//		});
//		
//		kompozicijeItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				KompozicijeProzor kp = new KompozicijeProzor(prodavnica);
//				kp.setVisible(true);
//			}
//		});
//		
//		diskoviItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				DiskoviProzor dp = new DiskoviProzor(prodavnica);
//				dp.setVisible(true);
//			}
//		});
//		
//		knjigeItem.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				KnjigeProzor kp = new KnjigeProzor(prodavnica);
//				kp.setVisible(true);
//			}
//		}
//		
//	}
}