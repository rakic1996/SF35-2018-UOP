package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Korisnik;
import osobe.Musterija;
import osobe.Uloga;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;

public class LoginProzor extends JFrame {

	private JLabel lblPozdrav = new JLabel("Dobrodosli. Molimo da se prijavite.");
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel lblSifra = new JLabel("Sifra:");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	private Taxi_sluzba taxi_sluzba;
	
	
	public LoginProzor(Taxi_sluzba taxi_sluzba) { 
		this.taxi_sluzba = taxi_sluzba;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		
		add(lblPozdrav, "span 2");
		add(lblKorIme);
		add(txtKorIme);
		add(lblSifra);
		add(pfPassword);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		
//		txtKorIme.setText("petarp");
//		pfPassword.setText("1234");
		getRootPane().setDefaultButton(btnOk);	
		
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
		 	@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
							
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String korisnickoIme = txtKorIme.getText().trim();
				String sifra = new String(pfPassword.getPassword()).trim();
				System.out.println("korisnicko ime " + korisnickoIme);
				System.out.println("sifra " + sifra);
				
				if (korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.", "Greska ", JOptionPane.WARNING_MESSAGE);
				} else {
					Korisnik prijavljeni = taxi_sluzba.login(korisnickoIme, sifra);
					if (prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci", " Greska", JOptionPane.WARNING_MESSAGE);
					}
					else {
						if (prijavljeni.getUloga().name().equals(Uloga.DISPECER.name())) {
							Dispecer dispecer = taxi_sluzba.pronadjiDispeceraPrekoKorisnika(prijavljeni);
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzor gp = new GlavniProzor(taxi_sluzba, dispecer);
							gp.setVisible(true);
							System.out.println(prijavljeni);
						} else if (prijavljeni.getUloga().name().equals(Uloga.MUSTERIJA.name())) {
							Musterija musterija = taxi_sluzba.pronadjiMusterijuPrekoKorisnika(prijavljeni);
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzor gp = new GlavniProzor(taxi_sluzba, musterija);
							gp.setVisible(true);
							System.out.println(prijavljeni);
						} else {
							Vozac vozac = taxi_sluzba.pronadjiVozacaPrekoKorisnika(prijavljeni);
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzor gp = new GlavniProzor(taxi_sluzba, vozac);
							gp.setVisible(true);
							System.out.println(prijavljeni);
						}
					}
						
				}				
			}
		});
	}
}
