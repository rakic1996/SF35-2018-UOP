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

import gui.FormeZaDodavanjeIIzmenu.DispeceriForma;
import gui.FormeZaDodavanjeIIzmenu.VozaciForma;
import gui.FormeZaDodavanjeIIzmenu.VoznjeForma;
import main.Taxi_sluzbaMain;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;
import voznja.Voznja;

public class VoznjeProzor extends JFrame {

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable voznjaTabela ;
	
	
	private Taxi_sluzba taxi_sluzba;
	
	
	public VoznjeProzor(Taxi_sluzba taxi_sluzba) {
		this.taxi_sluzba = taxi_sluzba;
		setTitle("Voznje");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
//		initActions();
		 
	}
	
	private void initGUI() {
//		ImageIcon addIcon = new ImageIcon(getClass().getResource("/icons/create.png"));
//		btnAdd.setIcon(addIcon);
//		ImageIcon editIcon = new ImageIcon(getClass().getResource("/icons/update.png"));
//		btnEdit.setIcon(editIcon);
//		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/icons/delete.jpg"));
//		btnDelete.setIcon(deleteIcon);
//		
//		
//		mainToolBar.add(btnAdd);
//		mainToolBar.add(btnEdit);
//		mainToolBar.add(btnDelete);
//		add(mainToolBar, BorderLayout.NORTH);
	
	////////OVO NE TREBA JER IDE SAMO PRIKAZ A NE CEO CRUD
		
		
		String [] zaglavlja = new String[] {"ID", "Datum porudzbine", "Adresa polaska", "Adresa destinacije",
											"Musterija", "Vozac", "Predjeni kilometri",
				 							"Trajanje voznje", "Status voznje","ID Automobila", "Kreirana telefonom"};
		Object[][] sadrzaj = new Object[taxi_sluzba.sveNeobrisaneVoznje().size()][zaglavlja.length];
		
		for(int i=0; i<taxi_sluzba.sveNeobrisaneVoznje().size(); i++) {
			Voznja voznja = taxi_sluzba.sveNeobrisaneVoznje().get(i);
			sadrzaj[i][0] = voznja.getId();
			sadrzaj[i][1] = voznja.getDatum_porudzbine();
			sadrzaj[i][2] = voznja.getAdresa_polaska();
			sadrzaj[i][3] = voznja.getAdresa_destinacije();
			sadrzaj[i][4] = voznja.getMusterija();
			sadrzaj[i][5] = voznja.getVozac();
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
		
		{		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		voznjaTabela = new JTable(tableModel);
		
		voznjaTabela .setRowSelectionAllowed(true);
		voznjaTabela .setColumnSelectionAllowed(false);
		voznjaTabela .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		voznjaTabela  .setDefaultEditor(Object.class, null);
		voznjaTabela .getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(voznjaTabela);
		add(scrollPane, BorderLayout.CENTER);
	}
}
}

//	private void initActions() {
		
		
//		btnDelete.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int red = voznjaTabela .getSelectedRow();
//				if(red == -1) {
//					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//				}else {
//					String korIme = tableModel.getValueAt(red, 3).toString();
//					Voznja voznja = taxi_sluzba.pronadjiVoznju(Id);
//					
//					int izbor = JOptionPane.showConfirmDialog(null, 
//							"Da li ste sigurni da zelite da obrisete vozaca?", 
//							korIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
//					if(izbor == JOptionPane.YES_OPTION) {
//						voznja.setObrisan(true);
//						tableModel.removeRow(red);
//						taxi_sluzba.snimiKorisnike(Taxi_sluzbaMain.VOZAC_FAJL);
//					}
//				}
//			}
//		});
//		
//		btnAdd.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				VozaciForma vf = new VozaciForma(taxi_sluzba, null);
//				vf.setVisible(true);
//			}
//		});
//		
//		
//		btnEdit.addActionListener(new ActionListener() {
//				
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int red = voznjaTabela .getSelectedRow();
//				if(red == -1) {
//					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
//				}else {
//					String korisnickoIme = tableModel.getValueAt(red, 3).toString();
//					Voznja voznja = taxi_sluzba.pronadjiVozaca(id);
//					if(voznja == null) {
//						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja vozaca sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
//					}else {
//						VoznjeForma vf = new VoznjeForma(taxi_sluzba, voznja);
//						vf.setVisible(true);
//						
//					}
//				}
//			}
//		});
//	}
//}
//}
//			
//			
		

