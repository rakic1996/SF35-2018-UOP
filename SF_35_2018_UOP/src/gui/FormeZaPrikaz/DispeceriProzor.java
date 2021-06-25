package gui.FormeZaPrikaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import gui.FormeZaDodavanjeIIzmenu.DispeceriForma;
import main.Taxi_sluzbaMain;
import osobe.Dispecer;
import taxi_sluzba.Taxi_sluzba;

public class DispeceriProzor extends JFrame {

	private JToolBar mainToolBar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable dispeceriTabela;
	
	
	private Taxi_sluzba taxi_sluzba;
	
	
	public DispeceriProzor(Taxi_sluzba taxi_sluzba) {
		this.taxi_sluzba = taxi_sluzba;
		setTitle("Dispeceri");
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
		
		
		String [] zaglavlja = new String[] {"Korisnicko ime", "Ime", "Prezime", "JMBG",
									"Adresa", "Pol", "Broj telefona", "Plata", 
									"Telefonska linija", "Odeljenje"};
		Object[][] sadrzaj = new Object[taxi_sluzba.sviNeobrisaniDispeceri().size()][zaglavlja.length];
		
		for(int i=0; i<taxi_sluzba.sviNeobrisaniDispeceri().size(); i++) {
			Dispecer dispecer = taxi_sluzba.sviNeobrisaniDispeceri().get(i);
			sadrzaj[i][0] = dispecer.getKorIme();
			sadrzaj[i][1] = dispecer.getIme();
			sadrzaj[i][2] = dispecer.getPrezime();
			sadrzaj[i][3] = dispecer.getJmbg();
			sadrzaj[i][4] = dispecer.getAdresa();
			sadrzaj[i][5] = dispecer.getPol();
			sadrzaj[i][6] = dispecer.getBrTelefona();
			sadrzaj[i][7] = dispecer.getPlata();
			sadrzaj[i][8] = dispecer.getTelefonska_linija();
			sadrzaj[i][9] = dispecer.getOdeljenje();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		dispeceriTabela = new JTable(tableModel);
		
		dispeceriTabela.setRowSelectionAllowed(true);
		dispeceriTabela.setColumnSelectionAllowed(false);
		dispeceriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dispeceriTabela.setDefaultEditor(Object.class, null);
		dispeceriTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(dispeceriTabela);
		add(scrollPane, BorderLayout.CENTER);
		
	}

	private void initActions() {
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = dispeceriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korIme = tableModel.getValueAt(red, 3).toString();
					Dispecer dispecer = taxi_sluzba.pronadjiDispecera(korIme);
					
					int izbor = JOptionPane.showConfirmDialog(null, 
							"Da li ste sigurni da zelite da obrisete dispecera?", 
							korIme + " - Porvrda brisanja", JOptionPane.YES_NO_OPTION);
					if(izbor == JOptionPane.YES_OPTION) {
						dispecer.setObrisan(true);
						tableModel.removeRow(red);
						taxi_sluzba.cuvanjeDispecera(Taxi_sluzbaMain.DISPECER_FAJL);
						//NE IDE OVO SNIMI ZAPOSLENE, TREBA VEROVATNO NAPRAVITI NOVU FUNKCIJU U TAXISLUZBA
					}
				}
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DispeceriForma df = new DispeceriForma(taxi_sluzba, null);
				df.setVisible(true);
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = dispeceriTabela.getSelectedRow();
				if(red == -1) {
					JOptionPane.showMessageDialog(null, "Morate odabrati red u tabeli.", "Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					String korIme = tableModel.getValueAt(red, 0).toString();
					Dispecer dispecer = taxi_sluzba.pronadjiDispecera(korIme);
					if(dispecer == null) {
						JOptionPane.showMessageDialog(null, "Greska prilikom pronalazenja dispecera sa tim korisnickim imenom", "Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						DispeceriForma pf = new DispeceriForma(taxi_sluzba, dispecer);
						pf.setVisible(true);
					}
				}
			}
		});
	}
		
}

	


