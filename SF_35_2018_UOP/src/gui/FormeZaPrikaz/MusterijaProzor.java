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
import gui.FormeZaDodavanjeIIzmenu.MusterijeForma;
import main.Taxi_sluzbaMain;
import osobe.Dispecer;
import osobe.Musterija;
import taxi_sluzba.Taxi_sluzba;

public class MusterijaProzor extends JFrame {

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable musterijeTabela;
	
	
	private Taxi_sluzba taxi_sluzba;
	
	
	public MusterijaProzor(Taxi_sluzba taxi_sluzba) {
		this.taxi_sluzba = taxi_sluzba;
		setTitle("Musterije");
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
				 							"JMBG", "Adresa", "Pol", "Broj telefona"};
		Object[][] sadrzaj = new Object[taxi_sluzba.sviNeobrisaniDispeceri().size()][zaglavlja.length];
		
		for(int i=0; i<taxi_sluzba.sveNeobrisaneMuterije().size(); i++) {
			Musterija musterija = taxi_sluzba.sveNeobrisaneMuterije().get(i);
			sadrzaj[i][0] = musterija.getKorIme();
			sadrzaj[i][1] = musterija.getIme();
			sadrzaj[i][2] = musterija.getPrezime();
			sadrzaj[i][3] = musterija.getJmbg();
			sadrzaj[i][4] = musterija.getAdresa();
			sadrzaj[i][4] = musterija.getPol();
			sadrzaj[i][4] = musterija.getBrTelefona();

		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		musterijeTabela = new JTable(tableModel);
		
		musterijeTabela.setRowSelectionAllowed(true);
		musterijeTabela.setColumnSelectionAllowed(false);
		musterijeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		musterijeTabela.setDefaultEditor(Object.class, null);
		musterijeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(musterijeTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = musterijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korIme = tableModel.getValueAt(red, 3).toString();
					Musterija musterija = taxi_sluzba.pronadjiMusteriju(korIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete musteriju?", 
							korIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						musterija.setObrisan(true);
						tableModel.removeRow(red);
						taxi_sluzba.cuvanjeMusterije(Taxi_sluzbaMain.MUSTERIJA_FAJL);
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MusterijeForma mf = new MusterijeForma(taxi_sluzba, null);
				mf.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = musterijeTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korIme = tableModel.getValueAt(red, 0).toString();
					Musterija musterija = taxi_sluzba.pronadjiMusteriju(korIme);
					if(musterija == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja musteriju sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						MusterijeForma mf = new MusterijeForma(taxi_sluzba, musterija);
						mf.setVisible(true);
					}
				}
			}
		});
	}
		
}

