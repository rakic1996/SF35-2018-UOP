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
import main.Taxi_sluzbaMain;
import osobe.Dispecer;
import osobe.Vozac;
import taxi_sluzba.Taxi_sluzba;

public class VozacProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable vozacTabela;
	
	
	private Taxi_sluzba taxi_sluzba;
	
	
	public VozacProzor(Taxi_sluzba taxi_sluzba) {
		this.taxi_sluzba = taxi_sluzba;
		setTitle("Vozac");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		 
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/icons/create.png"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/icons/update.png"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/icons/delete.jpg"));
		btnDelete.setIcon(deleteIcon);
		
		
		mainToolBar.add(btnAdd);
		mainToolBar.add(btnEdit);
		mainToolBar.add(btnDelete);
		add(mainToolBar, BorderLayout.NORTH);
		
		
		String [] zaglavlja = new String[] {"Korisnicko ime", "Ime", "Prezime",
				 							"JMBG", "Adresa", "Pol", "Broj telefona", "Plata",
				 							"Broj clanske karte", "ID Automobila"};
		Object[][] sadrzaj = new Object[taxi_sluzba.sviNeobrisaniDispeceri().size()][zaglavlja.length];
		
		for(int i=0; i<taxi_sluzba.sviNeobrisaniVozaci().size(); i++) {
			Vozac vozac = taxi_sluzba.sviNeobrisaniVozaci().get(i);
			sadrzaj[i][0] = vozac.getKorIme();
			sadrzaj[i][1] = vozac.getIme();
			sadrzaj[i][2] = vozac.getPrezime();
			sadrzaj[i][3] = vozac.getJmbg();
			sadrzaj[i][4] = vozac.getAdresa();
			sadrzaj[i][5] = vozac.getPol();
			sadrzaj[i][6] = vozac.getBrTelefona();
			sadrzaj[i][7] = vozac.getPlata();
			sadrzaj[i][8] = vozac.getClanska_karta();
			sadrzaj[i][9] = vozac.getAutomobil();

		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		vozacTabela = new JTable(tableModel);
		
		vozacTabela.setRowSelectionAllowed(true);
		vozacTabela.setColumnSelectionAllowed(false);
		vozacTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vozacTabela.setDefaultEditor(Object.class, null);
		vozacTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(vozacTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = vozacTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korIme = tableModel.getValueAt(red, 3).toString();
					Vozac vozac = taxi_sluzba.pronadjiVozaca(Id);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete vozaca?", 
							korIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						vozac.setObrisan(true);
						tableModel.removeRow(red);
						taxi_sluzba.snimiKorisnike(Taxi_sluzbaMain.VOZAC_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VozaciForma vf = new VozaciForma(taxi_sluzba, null);
				vf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = vozacTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korisnickoIme = tableModel.getValueAt(red, 3).toString();
					Vozac vozac = taxi_sluzba.pronadjiVozaca(id);
					if(vozac == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja vozaca sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						VozaciForma vf = new DispeceriForma(taxi_sluzba, vozac);
						vf.setVisible(true);
					}
				}
			}
		});
	}
}

