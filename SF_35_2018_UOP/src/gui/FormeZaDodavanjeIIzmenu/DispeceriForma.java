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

import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Uloga;
import taxi_sluzba.Taxi_sluzba;

public class DispeceriForma extends JFrame {
	
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel txtLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new  JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Naziv");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblTelLinija = new JLabel("Telefonska linija");
	private JTextField txtTelLinija = new JTextField(20);
	private JLabel lblOdeljenje = new JLabel("Odeljenje");
	private JComboBox<Odeljenje> cbOdeljenje = new JComboBox<Odeljenje>(Odeljenje.values());
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	
	private Dispecer dispecer;
	private Taxi_sluzba taxi_sluzba;
	
	public DispeceriForma(Taxi_sluzba taxi_sluzba, Dispecer dispecer) {
		this.taxi_sluzba = taxi_sluzba;
		this.dispecer = dispecer;
		if(dispecer == null) {
			setTitle("Dodavanje dispecera");
		}else {
			setTitle("Izmena podataka - " + dispecer.getKorIme());
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
		
		if(dispecer != null) {
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
		add(lblTelLinija);
		add(txtTelLinija);
		add(lblOdeljenje);
		add(cbOdeljenje);
		add(lblAdresa);
		add(txtAdresa);
		add(lblJmbg);
		add(txtJmbg);
		add(new JLabel());
		add(btnOK, "split 2");
		add(btnCancel);
	}
	

	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String korIme = txtKorIme.getText().trim();
					String lozinka = txtLozinka .getText().trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brTelefona = txtBrTelefona.getText().trim();
//					String id = txtID.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					String telefonska_linija = txtTelLinija.getText().trim();
					Odeljenje odeljenje = (Odeljenje)cbOdeljenje.getSelectedItem();
					String adresa = txtAdresa.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					
					if(dispecer == null) { // DODAVANJE:
						Dispecer novi = new Dispecer(korIme, lozinka, ime, prezime, jmbg,
								adresa, pol, brTelefona, false, plata,telefonska_linija, odeljenje, Uloga.DISPECER);
								
						taxi_sluzba.dodajDispecera(novi);
					}else {
						dispecer.setKorIme(korIme);
						dispecer.setIme(ime);
						dispecer.setPrezime(prezime);
						dispecer.setPol(pol);
						dispecer.setBrTelefona(brTelefona);
//						dispecer.setId(id);
						dispecer.setPlata(plata);
						dispecer.setTelefonska_linija(telefonska_linija);
						dispecer.setOdeljenje(odeljenje);
						dispecer.setAdresa(adresa);
						dispecer.setJmbg(jmbg);
					}
//					taxi_sluzba.//////////////////////(Taxi_sluzbaMain.DISPECER_FAJL);
					DispeceriForma.this.dispose();
					DispeceriForma.this.setVisible(false);
				}
			}
		});
	};
	
	
	private void popuniPolja() {
		txtKorIme.setText(String.valueOf(dispecer.getPlata()));
		txtIme.setText(dispecer.getIme());
		txtPrezime.setText(dispecer.getPrezime());
		cbPol.setSelectedItem(dispecer.getPol());
		txtBrTelefona.setText(dispecer.getBrTelefona());
		txtPlata.setText("" + dispecer.getPlata());
		txtTelLinija.setText(dispecer.getTelefonska_linija());
		cbOdeljenje.setSelectedItem(dispecer.getOdeljenje());
		txtAdresa.setText(dispecer.getAdresa());
		txtJmbg.setText(dispecer.getAdresa());
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Morate uneti korisnicko ime\n";
			ok = false;
		}else if(dispecer == null) {
			String korIme = txtKorIme.getText().trim();
			Dispecer pronadjen = taxi_sluzba.pronadjiDispecera(korIme);
			if(pronadjen != null) {
				poruka += "- Dispecer sa unetim korisnickim imenom vec postoji\n";
				ok = false;
			}
		}
		
		try {
			Double.parseDouble(txtPlata.getText().trim());
		} catch (NumberFormatException e) {
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
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
