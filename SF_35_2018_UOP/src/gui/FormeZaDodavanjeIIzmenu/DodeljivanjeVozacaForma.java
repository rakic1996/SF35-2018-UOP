package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import automobil.Automobil;
import main.Taxi_sluzbaMain;
import net.miginfocom.swing.MigLayout;
import osobe.Pol;
import osobe.Uloga;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.Voznja;

public class DodeljivanjeVozacaForma extends JFrame {

	private JLabel lblIzaberite = new JLabel("Izaberite vozaca");
	private JComboBox<String> cbVozaci = new JComboBox<String>();
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Taxi_sluzba taxi_sluzba;
	private Voznja voznja;
	
	
	public DodeljivanjeVozacaForma(Taxi_sluzba taxiSluzba, Integer voznjaId) {
		this.taxi_sluzba = taxiSluzba;
		
		this.voznja = taxiSluzba.pronadjiVoznju(voznjaId);
		
		popuni();
		
		setTitle("Dodeljivanje vozaca voznji");
		
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
		
		add(lblIzaberite);
		add(cbVozaci);
		add(btnOK);
		add(btnCancel);
	}
	
	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String vozacKorIme = (String) cbVozaci.getSelectedItem();
					
					taxi_sluzba.dodeliVozacaVoznji(voznja, vozacKorIme);
					
					DodeljivanjeVozacaForma.this.dispose();
					DodeljivanjeVozacaForma.this.setVisible(false);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DodeljivanjeVozacaForma.this.dispose();
				DodeljivanjeVozacaForma.this.setVisible(false);
			}
		});
	}
	
	public void popuni() {
		List<Vozac> vozaci = taxi_sluzba.getVozaci();
		for (Vozac vozac : vozaci) {
			cbVozaci.addItem(vozac.getKorIme());
		}
	}
	
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if (cbVozaci.getSelectedIndex() == -1) {
			poruka += "- Morate selektovati vozaca\n";
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
