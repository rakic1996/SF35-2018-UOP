package gui.FormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.FormeZaDodavanjeIIzmenu.ZavrsavanjeVoznjeForma;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.Voznja;

public class PrihvaceneVoznjeProzor extends JFrame {

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnZavrsi = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable voznjaTabela ;
	
	
	private Taxi_sluzba taxi_sluzba;
	private Vozac prijavljeniVozac;
	
	public PrihvaceneVoznjeProzor(Taxi_sluzba taxi_sluzba, Vozac prijavljeniVozac) {
		this.taxi_sluzba = taxi_sluzba;
		this.prijavljeniVozac = prijavljeniVozac;
		
		setTitle("Prihvacene voznje");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		 
	}
	
	private void initGUI() {
		
		ImageIcon zavrsiIcon = new ImageIcon(getClass().getResource("/icons/delete.jpg"));
		btnZavrsi.setIcon(zavrsiIcon);
		mainToolBar.add(btnZavrsi);
		
		
		add(mainToolBar, BorderLayout.NORTH);
	
		ucitajTabelu();
		
		{		
			voznjaTabela.setRowSelectionAllowed(true);
			voznjaTabela.setColumnSelectionAllowed(false);
			voznjaTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			voznjaTabela.setDefaultEditor(Object.class, null);
			voznjaTabela.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane scrollPane = new JScrollPane(voznjaTabela);
			add(scrollPane, BorderLayout.CENTER);
		}
	}
	
	public void ucitajTabelu() {
		String [] zaglavlja = new String[] {"ID", "Datum porudzbine", "Adresa polaska", "Adresa destinacije",
											"Musterija", "Vozac", "Predjeni kilometri",
											"Trajanje voznje", "Status voznje","ID Automobila", "Kreirana telefonom"};
		
		Object[][] sadrzaj = new Object[taxi_sluzba.svePrihvaceneVoznje(this.prijavljeniVozac).size()][zaglavlja.length];
		
		for(int i=0; i<taxi_sluzba.svePrihvaceneVoznje(this.prijavljeniVozac).size(); i++) {
			Voznja voznja = taxi_sluzba.svePrihvaceneVoznje(this.prijavljeniVozac).get(i);
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum_porudzbine();
			sadrzaj[i][2] = voznja.getAdresa_polaska();
			sadrzaj[i][3] = voznja.getAdresa_destinacije();
			sadrzaj[i][4] = voznja.getMusterija();
			if (voznja.getVozac() != null) {
				sadrzaj[i][5] = voznja.getVozac().getKorIme();
			} else {
				sadrzaj[i][5] = "/";
			}
			sadrzaj[i][6] = voznja.getPredjeni_km();
			sadrzaj[i][7] = voznja.getTrajanje_voznje();
			sadrzaj[i][8] = voznja.getStatus_voznje();
			if (voznja.getAuto() != null) {
				sadrzaj[i][9] = voznja.getAuto().getId() + "";
			} else {
				sadrzaj[i][9] = "";
			}
			sadrzaj[i][10] = voznja.isKreiranaPutemTelefona();
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		voznjaTabela = new JTable(tableModel);
		
	}

	private void initActions() {
		
		btnZavrsi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = voznjaTabela .getSelectedRow();
				if (red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				} else {
					String voznjaIdStr = tableModel.getValueAt(red, 0).toString();
					Integer voznjaId = Integer.parseInt(voznjaIdStr);
					Voznja voznja = taxi_sluzba.pronadjiVoznju(voznjaId);
					
					if (voznja != null) {
						ZavrsavanjeVoznjeForma zvf = new ZavrsavanjeVoznjeForma(taxi_sluzba, voznja);
						zvf.setVisible(true);
					}
				}
			}
		});
	}		
		
}


