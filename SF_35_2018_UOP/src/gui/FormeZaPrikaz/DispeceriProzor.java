package gui.FormeZaPrikaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

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
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/icons/add.png"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/icons/edit.png"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/icons/delete.png"));
		btnDelete.setIcon(deleteIcon);
		
		
		mainToolBar.add(btnAdd);
		mainToolBar.add(btnEdit);
		mainToolBar.add(btnDelete);
		add(mainToolBar, BorderLayout.NORTH);
		
		
		String [] zaglavlja = new String[] {"Korisnicko ime", "Ime", "Prezime", "JMBG", "Adresa",
									"Pol", "ID", "Plata", "Telefonska linija", "Odeljenje"};
		
		
		Object[][] sadrzaj = new Object[taxi_sluzba]
		
	}

	private void initActions() {
		
	}

	
}

