package gui.FormeZaDodavanjeIIzmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.Taxi_sluzbaMain;
import net.miginfocom.swing.MigLayout;
import taxi_sluzba.Taxi_sluzba;
import voznja.StatusVoznje;
import voznja.Voznja;

public class ZavrsavanjeVoznjeForma extends JFrame {

	private JLabel lblBrojKm = new JLabel("Broj kilometara voznje");
	private JLabel lblTrajanjeVoznje = new JLabel("Trajanje voznje");
	private JTextField txtBrojKm = new JTextField(20);
	private JTextField txtTrajanjeVoznje = new JTextField(20);
	
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private Taxi_sluzba taxi_sluzba;
	private Voznja voznja;
	
	public ZavrsavanjeVoznjeForma(Taxi_sluzba taxiSluzba, Voznja voznja) {
		this.taxi_sluzba = taxiSluzba;
		
		this.voznja = voznja;
		
		setTitle("Zavrsavanje voznje");
		
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
		
		add(lblBrojKm);
		add(lblTrajanjeVoznje);
		add(txtBrojKm);
		add(txtTrajanjeVoznje);
		add(btnOK);
		add(btnCancel);
	}
	
	private void initActions() {
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					String brojKmStr = (String) txtBrojKm.getText().trim();
					Double brojKm = Double.parseDouble(brojKmStr);
					
					String trajanjeVoznjeStr = (String) txtTrajanjeVoznje.getText().trim();
					Double trajanjeVoznje = Double.parseDouble(trajanjeVoznjeStr);
					
					voznja.setPredjeni_km(brojKm);
					voznja.setTrajanje_voznje(trajanjeVoznje);
					voznja.setStatus_voznje(StatusVoznje.zavrsena);
					taxi_sluzba.izmeniVoznjuUFajlu(voznja, Taxi_sluzbaMain.VOZNJA_FAJL);
					
					ZavrsavanjeVoznjeForma.this.dispose();
					ZavrsavanjeVoznjeForma.this.setVisible(false);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ZavrsavanjeVoznjeForma.this.dispose();
				ZavrsavanjeVoznjeForma.this.setVisible(false);
			}
		});
	}
	
	
	public boolean validacija() {
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if (txtBrojKm.getText().trim().equals("")) {
			poruka += "- Morate uneti broj km\n";
			ok = false;
		}
		try {
			Double.parseDouble(txtBrojKm.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Broj km mora biti broj\n";
			ok = false;
		}
		
		if (txtTrajanjeVoznje.getText().trim().equals("")) {
			poruka += "- Morate uneti trajanje voznje\n";
			ok = false;
		}
		try {
			Double.parseDouble(txtTrajanjeVoznje.getText().trim());
		}catch (NumberFormatException e) {
			poruka += "- Trajanje voznje mora biti broj\n";
			ok = false;
		}
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
}
