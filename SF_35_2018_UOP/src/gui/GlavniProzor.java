package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.FormeZaDodavanjeIIzmenu.ZakazivanjeVoznjeForma;
import gui.FormeZaPrikaz.DispeceriProzor;
import gui.FormeZaPrikaz.DodeljeneVoznjeProzor;
import gui.FormeZaPrikaz.MusterijaProzor;
import gui.FormeZaPrikaz.PrihvaceneVoznjeProzor;
import gui.FormeZaPrikaz.VozacProzor;
import gui.FormeZaPrikaz.VoznjeProzor;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;



public class GlavniProzor extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu korisniciMenu = new JMenu("Korisnici");
	private JMenu zakaziVoznju = new JMenu("Zakazi voznju");
	private JMenu voznjeZaVozaca = new JMenu("Voznje");
	private JMenuItem dodeljeneVoznje = new JMenuItem("Dodeljene voznje");
	private JMenuItem prihvaceneVoznje = new JMenuItem("Prihvacene voznje");
	private JMenuItem putemTelefona = new JMenuItem("Putem telefona");
	private JMenuItem dispeceriItem = new JMenuItem("Dispeceri");
	private JMenuItem musterijeItem = new JMenuItem("Musterije");
	private JMenuItem vozaciItem = new JMenuItem("Vozaci");
	private JMenu voznjeMenu = new JMenu("Voznje");
	private JMenuItem voznjeItem = new JMenuItem("Voznje");
	
	private Taxi_sluzba taxi_sluzba;
	private Dispecer prijavljeniDispecer;
	private Musterija prijavljenaMusterija;
	private Vozac prijavljeniVozac;
	
	public GlavniProzor() {
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public GlavniProzor(Taxi_sluzba taxi_sluzba, Dispecer prijavljeniKorisnik) {
		this();
		this.taxi_sluzba = taxi_sluzba;
		this.prijavljeniDispecer = prijavljeniKorisnik;
		setTitle("Dispecer: " + prijavljeniKorisnik.getKorIme());
		initMenu();
		initActions();
	}
	
	public GlavniProzor(Taxi_sluzba taxi_sluzba, Musterija prijavljenaMusterija) {
		this();
		this.taxi_sluzba = taxi_sluzba;
		this.prijavljenaMusterija = prijavljenaMusterija;
		setTitle("Musterija: " + prijavljenaMusterija.getKorIme());
//		initMenu();
		initActions();
		setJMenuBar(mainMenu);
		mainMenu.add(zakaziVoznju);
		zakaziVoznju.add(putemTelefona);


	}
	
	public GlavniProzor(Taxi_sluzba taxi_sluzba, Vozac prijavljenaVozac) {
		this();
		this.taxi_sluzba = taxi_sluzba;
		this.prijavljeniVozac = prijavljenaVozac;
		setTitle("Vozac: " + prijavljenaVozac.getKorIme());
//		initMenu();
		initActions();
		setJMenuBar(mainMenu);
		mainMenu.add(voznjeZaVozaca);
		voznjeZaVozaca.add(dodeljeneVoznje);
		voznjeZaVozaca.add(prihvaceneVoznje);
	}
	
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(korisniciMenu);
		korisniciMenu.add(dispeceriItem);
		korisniciMenu.add(musterijeItem);
		korisniciMenu.add(vozaciItem);
		mainMenu.add(voznjeMenu);
		voznjeMenu.add(voznjeItem);
	
	}
	
	private void initActions() {
		voznjeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VoznjeProzor vp = new VoznjeProzor(taxi_sluzba);
				vp.setVisible(true);
			}
		});
		
		dispeceriItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				DispeceriProzor dp = new DispeceriProzor(taxi_sluzba);
				dp.setVisible(true);
			}
		});
			
		musterijeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijaProzor mp = new MusterijaProzor(taxi_sluzba);
				mp.setVisible(true);
			}
		});
			
		vozaciItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VozacProzor vp = new VozacProzor(taxi_sluzba);
				vp.setVisible(true);
			}
		});
		putemTelefona.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZakazivanjeVoznjeForma zkf = new ZakazivanjeVoznjeForma(taxi_sluzba, prijavljenaMusterija, true);
				zkf.setVisible(true);
			}
		});
		dodeljeneVoznje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodeljeneVoznjeProzor zkf = new DodeljeneVoznjeProzor(taxi_sluzba, prijavljeniVozac);
				zkf.setVisible(true);
			}
		});
		prihvaceneVoznje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrihvaceneVoznjeProzor zkf = new PrihvaceneVoznjeProzor(taxi_sluzba, prijavljeniVozac);
				zkf.setVisible(true);
			}
		});
		
		
	}		
	
	
		

}