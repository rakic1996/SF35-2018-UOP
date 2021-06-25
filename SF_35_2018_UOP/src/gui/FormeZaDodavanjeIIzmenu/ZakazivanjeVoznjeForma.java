package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Taxi_sluzbaMain;
import net.miginfocom.swing.MigLayout;
import osobe.Musterija;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class ZakazivanjeVoznjeForma extends JFrame {

	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska");
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JTextField txtAdresaDestinacije = new JTextField(20);
	
	private JButton btnZakazi = new JButton("Zakazi");
	private JButton btnCancel = new JButton("Cancel");
	
	private Taxi_sluzba taxi_sluzba;
	private Musterija prijavljenaMusterija;
	
	private boolean kreiranaPutemTelefona;
	
	public ZakazivanjeVoznjeForma(Taxi_sluzba taxiSluzba, Musterija prijavljenaMusterija, boolean kreiranaPutemTelefona) {
		this.taxi_sluzba = taxiSluzba;
		this.prijavljenaMusterija = prijavljenaMusterija;
		this.kreiranaPutemTelefona = kreiranaPutemTelefona;
		
		setTitle("Zakazivanje voznje");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(new JLabel());
		add(btnZakazi, "split 2");
		add(btnCancel);
	}
	
	private void initActions() {
		btnZakazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String adresaPolaska = txtAdresaPolaska.getText().trim();
					String adresaDestinacije = txtAdresaDestinacije.getText().trim();
					
					taxi_sluzba.zakaziVoznju(prijavljenaMusterija, adresaPolaska, adresaDestinacije, kreiranaPutemTelefona);
					
					ZakazivanjeVoznjeForma.this.dispose();
					ZakazivanjeVoznjeForma.this.setVisible(false);
				}
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZakazivanjeVoznjeForma.this.dispose();
				ZakazivanjeVoznjeForma.this.setVisible(false);
			}
		});
	};
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtAdresaPolaska.getText().trim().equals("")) {
			poruka += "- Morate uneti adresu polaska\n";
			ok = false;
		}
		
		if(txtAdresaDestinacije.getText().trim().equals("")) {
			poruka += "- Morate uneti adresu destinacije\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni kreirano zakazivanje", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
