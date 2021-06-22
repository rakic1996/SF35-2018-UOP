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
import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;

public class VozaciForma extends JFrame {
	
	protected static final boolean Odeljenje = false;
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel txtLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new  JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(20);
//	private JLabel lblID = new JLabel("ID");
//	private JTextField txtID = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblClanska_karta = new JLabel("Clanska karta");
	private JTextField txtClanska_karta = new JTextField(20); 
	private JLabel lblAutomobil = new JLabel("Automobil");
	private JComboBox<Automobil> cbAutomobil = new JComboBox<Automobil>(Automobil.values());//OVDE NE IDE VALUES NEGO NESTO DRUGO JER NIJE ENUM NEGO CEO OBJEKAT
	



	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	
	private Vozac vozac;
	private Taxi_sluzba taxi_sluzba;
	
	public VozaciForma(Taxi_sluzba taxi_sluzba, Vozac vozac) {
		this.taxi_sluzba = taxi_sluzba;
		this.vozac = vozac;
		if(vozac == null) {
			setTitle("Dodavanje vozaca");
		}else {
			setTitle("Izmena podataka - " + vozac.getId());
		}
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
		
		if(vozac != null) {
			popuniPolja();
		}
		
		add(lblKorIme);
		add(txtKorIme);
		add(txtLozinka);
		add(pfLozinka);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblPol);
		add(cbPol);
		add(lblBrTelefona);
		add(txtBrTelefona);
//		add(lblID);
//		add(txtID);
		add(lblPlata);
		add(txtPlata);
		add(lblAdresa);
		add(txtAdresa);
		add(lblJmbg);
		add(txtJmbg);
		add(lblClanska_karta);
		add(txtClanska_karta);
		add(lblAutomobil);
		add(cbAutomobil);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	

	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			private String clanska_karta;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String korIme = txtKorIme.getText().trim();
					String lozinka = txtLozinka .getText().trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brTelefona = txtBrTelefona.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					String clanskaKarta = txtClanska_karta.getText().trim();
					Automobil automobil = (Automobil)cbAutomobil.getSelectedItem();
					
//					String id = txtID.getText().trim();

					
					
					if(vozac == null) { // DODAVANJE:
						Vozac novi = new Vozac(korIme, lozinka, ime, prezime, jmbg,
								adresa, pol, brTelefona, plata, clanskaKarta, automobil);
								
						taxi_sluzba.dodajVozace(novi);
					}else {
						vozac.setKorIme(korIme);
						vozac.setIme(ime);
						vozac.setPrezime(prezime);
						vozac.setJmbg(jmbg);
						vozac.setAdresa(adresa);
						vozac.setPol(pol);
						vozac.setBrTelefona(brTelefona);
						vozac.setPlata(plata);
//						dispecer.setId(id);
						vozac.setPlata(plata);
						vozac.setClanska_karta(clanska_karta);
						vozac.setAutomobil(automobil);
						


					}
					taxi_sluzba.//////////////////////(Taxi_sluzbaMain.DISPECER_FAJL);
					VozaciForma.this.dispose();
					VozaciForma.this.setVisible(false);
				}
			}
		});
	};
	
	private void popuniPolja() {
		txtKorIme.setText(String.valueOf(vozac.getPlata()));
		txtIme.setText(vozac.getIme());
		txtPrezime.setText(vozac.getPrezime());
		cbPol.setSelectedItem(vozac.getPol());
		txtBrTelefona.setText(vozac.getBrTelefona());
		txtPlata.setText(vozac.setPlata());
		txtAdresa.setText(vozac.getAdresa());
		txtJmbg.setText(vozac.getAdresa());
//		txtID.setText(dispecer.getId());
		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Morate uneti korisnicko ime\n";
			ok = false;
		}else if(vozac == null) {
			String id = txtKorIme.getText().trim();
			Dispecer pronadjen = taxi_sluzba.pronadjiVozaca(id);
			if(pronadjen != null) {
				poruka += "- Vozac sa unetim korisnickim imenom vec postoji\n";
				ok = false;
			}
		}
		
		try {
			Double.parseDouble(txtPlata.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Plata mora biti broj\n";
			ok = false;
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Morate uneti ime\n";
			ok = false;
		}
		
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Morate uneti prezime\n";
			ok = false;
			
		}
		String lozinka = new String(pfLozinka.getPassword()).trim();
		if(lozinka.equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}

}
