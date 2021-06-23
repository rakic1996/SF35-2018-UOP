package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import automobil.Automobil;
import main.Taxi_sluzbaMain;
import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Pol;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class VoznjeForma extends JFrame {
	
	private JLabel lblID = new JLabel("ID");
	private JTextField txtID = new JTextField(20);
	private JLabel lblDatumPorudzbine = new JLabel("Datum porudzbine");
	private JPasswordField txtDatumPorudzbine = new JPasswordField(20);
	private JLabel lblAdresaPolaska = new  JLabel("Adresa polaska");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JLabel lblMusterija = new JLabel("Musterija");
	private JComboBox<Musterija> cbMusterija = new JComboBox<Musterija>();//////
	private JLabel lblVozac = new JLabel("Vozac");
	private JComboBox<Vozac> cbVozac = new JComboBox<Vozac>();//////
	private JLabel lblPredjeniKm = new JLabel("Predjeni kilometri");
	private JTextField txtPredjeniKm = new JTextField(20);
//	private JLabel lblID = new JLabel("ID");
//	private JTextField txtID = new JTextField(20);
	private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje");
	private JTextField txtTrajanjeVoznje = new JTextField(20);
	private JLabel lblStatusVoznje = new JLabel("Status voznje");
	private JComboBox<StatusVoznje> cbStatusVoznje = new JComboBox<StatusVoznje>(StatusVoznje.values());




	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	
	private Voznja voznja;
	private Taxi_sluzba taxi_sluzba;
	
	public VoznjeForma(Taxi_sluzba taxi_sluzba, Voznja voznja) {
		this.taxi_sluzba = taxi_sluzba;
		this.voznja = voznja;
		if(voznja == null) {
			setTitle("Dodavanje voznji");
		}else {
			setTitle("Izmena podataka - " + voznja.getId());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
//		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
		setLayout(layout);
		
//		if(voznja != null) {
//			popuniPolja();
//		}
		
		add(lblID);
		add(txtID);
		add(lblDatumPorudzbine);
		add(txtDatumPorudzbine);
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(lblMusterija);
		add(cbMusterija);
		add(lblVozac);
		add(cbVozac);
		add(lblPredjeniKm);
		add(txtPredjeniKm);
		add(lblTrajanjeVoznje);
		add(txtTrajanjeVoznje);
		add(lblStatusVoznje);
		add(cbStatusVoznje);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	

//	private void initActions() {
//		btnOK.addActionListener(new ActionListener() {
//			private String clanska_karta;
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(validacija()) {
//					String ID = txtID.getText().trim();
//					String datum_porudzbine = txtDatumPorudzbine.getText().trim();
//					String adresa_polaska = txtAdresaPolaska.getText().trim();
//					String adresa_destinacije = txtAdresaDestinacije.getText().trim();
//					Musterija musterija = (Musterija)cbMusterija.getSelectedItem();
//					Vozac vozac = (Vozac)cbVozac.getSelectedItem();
//					Double predjeni_km = Double.parseDouble(txtPredjeniKm.getText().trim());
//					Double trajanje_voznje = Double.parseDouble(txtTrajanjeVoznje.getText().trim());
//					StatusVoznje status_voznje = (StatusVoznje)cbStatusVoznje.getSelectedItem();
//								
//					
//					if(voznja == null) { // DODAVANJE:
//						Voznja  novi = new Voznja(ID, datum_porudzbine, adresa_polaska,
//								adresa_destinacije, musterija, vozac, predjeni_km, trajanje_voznje,
//								status_voznje);
//								
//								
//						taxi_sluzba.dodajVoznju(novi);
//					}else {
//						voznja.setDatum_porudzbine(datum_porudzbine);
//						voznja.setAdresa_polaska(adresa_polaska);
//						voznja.setAdresa_destinacije(adresa_destinacije);
//						voznja.setMusterija(musterija);
//						voznja.setVozac(vozac);
//						voznja.setPredjeni_km(predjeni_km);
//						voznja.setTrajanje_voznje(trajanje_voznje);
//						voznja.setStatus_voznje(status_voznje);
//
//
//					}
//					taxi_sluzba.cuvanjeVoznji(Taxi_sluzbaMain.VOZNJA_FAJL);
//					VoznjeForma.this.dispose();
//					VoznjeForma.this.setVisible(false);
//				}
//			}
//		});
//	};
	
//	private void popuniPolja() {
//		txtID.setText(voznja.getId());
//		txtDatumPorudzbine.setText(voznja.getDatum_porudzbine());
//		txtAdresaPolaska.setText(voznja.getAdresa_polaska());
//		txtAdresaDestinacije.setText(voznja.getAdresa_destinacije());
//		cbMusterija.setSelectedItem(voznja.getMusterija());
//		cbVozac.setSelectedItem(voznja.getVozac());
//		txtPredjeniKm.setText(voznja.getPredjeni_km());
//		txtTrajanjeVoznje.setText(voznja.getTrajanje_voznje());
//		cbStatusVoznje.setSelectedItem(voznja.getStatus_voznje());
//		
//	}
	
//	private boolean validacija() {
//		boolean ok = true;
//		String poruka = "Molimo popravite sledece greske u unosu:\n";
//		
//		if(txt.getText().trim().equals("")) {
//			poruka += "- Morate uneti korisnicko ime\n";
//			ok = false;
//		}else if(vozac == null) {
//			String id = txtKorIme.getText().trim();
//			Dispecer pronadjen = taxi_sluzba.pronadjiVozaca(id);
//			if(pronadjen != null) {
//				poruka += "- Vozac sa unetim korisnickim imenom vec postoji\n";
//				ok = false;
//			}
//		}
//		
//		try {
//			Double.parseDouble(txtPlata.getText().trim());
//		}catch (NumberFormatException e) {
//			poruka += "- Plata mora biti broj\n";
//			ok = false;
//		}
//		
//		if(txtIme.getText().trim().equals("")) {
//			poruka += "- Morate uneti ime\n";
//			ok = false;
//		}
//		
//		if(txtPrezime.getText().trim().equals("")) {
//			poruka += "- Morate uneti prezime\n";
//			ok = false;
//			
//		}
//		String lozinka = new String(pfLozinka.getPassword()).trim();
//		if(lozinka.equals("")) {
//			poruka += "- Unesite lozinku\n";
//			ok = false;
//		
//		
//		if(ok == false) {
//			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
//		}
//		return ok;
//	}
//	


}
