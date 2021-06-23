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

import main.Taxi_sluzbaMain;
import net.miginfocom.swing.MigLayout;
import osobe.Dispecer;
import osobe.Musterija;
import osobe.Odeljenje;
import osobe.Pol;
import osobe.Uloga;
import taxi_sluzba.Taxi_sluzba;

public class MusterijeForma extends JFrame {
	
	private JLabel lblKorIme = new JLabel("Korisnicko ime");
	private JTextField txtKorIme = new JTextField(20);
	private JLabel txtLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new  JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cbPol = new JComboBox<Pol>(Pol.values());
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(20);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");

	
	private Musterija musterija;
	private Taxi_sluzba taxi_sluzba;
	
	public MusterijeForma(Taxi_sluzba taxi_sluzba, Musterija musterija) {
		this.taxi_sluzba = taxi_sluzba;
		this.musterija = musterija;
		if(musterija == null) {
			setTitle("Dodavanje musteriju");
		}else {
			setTitle("Izmena podataka - " + musterija.getKorIme());
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
		
		if(musterija != null) {
			txtKorIme.setEnabled(false);
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
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					Pol pol = (Pol)cbPol.getSelectedItem();
					String brTelefona = txtBrTelefona.getText().trim();

					if(musterija == null) { // DODAVANJE:
						Musterija nova = new Musterija(korIme, lozinka, ime, prezime, jmbg,
								adresa, pol, brTelefona, false, Uloga.MUSTERIJA);
								
						taxi_sluzba.dodajMusteriju(nova);
					}else {
						musterija.setKorIme(korIme);
						musterija.setIme(ime);
						musterija.setPrezime(prezime);
						musterija.setPol(pol);
						musterija.setBrTelefona(brTelefona);
						musterija.setAdresa(adresa);
						musterija.setJmbg(jmbg);
					}
					taxi_sluzba.cuvanjeMusterije(Taxi_sluzbaMain.MUSTERIJA_FAJL);
					MusterijeForma.this.dispose();
					MusterijeForma.this.setVisible(false);
				}
			}
		});
	};
	
	private void popuniPolja() {
		txtKorIme.setText(musterija.getKorIme());
		pfLozinka.setText(musterija.getLozinka());
		txtIme.setText(musterija.getIme());
		txtPrezime.setText(musterija.getPrezime());
		txtJmbg.setText(musterija.getJmbg());
		txtAdresa.setText(musterija.getAdresa());
		cbPol.setSelectedItem(musterija.getPol());
		txtBrTelefona.setText(musterija.getBrTelefona());
//		txtID.setText(musterija.setId());
		

		
	}
	
	private boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Morate uneti korisnicko ime\n";
			ok = false;
		}else if(musterija == null) {
			String korIme = txtKorIme.getText().trim();
			Musterija pronadjen = taxi_sluzba.pronadjiMusteriju(korIme);
			if(pronadjen != null) {
				poruka += "- Musterija sa unetim korisnickim imenom vec postoji\n";
				ok = false;
			}
		}
		
		if(txtIme.getText().trim().equals("")) {
			poruka += "- Morate uneti ime\n";
			ok = false;
		}
		
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Morate uneti prezime\n";
			ok = false;
		}
		
		if(txtKorIme.getText().trim().equals("")) {
			poruka += "- Morate uneti korisnicko ime\n";
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
