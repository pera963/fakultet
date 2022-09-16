import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class lista_studenta_predmeta extends JFrame {

	private JPanel contentPane;
    private JList<student> listaStudenata ;
	private JList listaPredmeta;
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lista_studenta_predmeta frame = new lista_studenta_predmeta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public lista_studenta_predmeta() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listaStudenata = new JList();
		listaStudenata.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				//OVO SE DESAVA KADA IZABEREMO STUDENTA
				try {
					PopuniPredmeteZaStudenta();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		listaStudenata.setBounds(10, 11, 328, 459);
		contentPane.add(listaStudenata);
		
		listaPredmeta = new JList();
		listaPredmeta.setBounds(362, 11, 328, 459);
		contentPane.add(listaPredmeta);
		popuniListuIzBaze();
	}
	
	public void popuniListuIzBaze() throws SQLException {
		
		KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=KONEKCIJA.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
		
		//ova komadna uzima sve klijente iz baze
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from student");
			
		//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
		ResultSet rs=ps.executeQuery();
		
		DefaultListModel dl=new DefaultListModel();// to ne ide ako pravimo samo textArea jer nemamo listu
		
		String textZaPostavljenje="";// ne znam šta mu je ovo?????
		while (rs.next()) {
			
			int iDSTUDENT=rs.getInt("IDStudent");  //"ID"mora da bude isto kao i u Bazi			
			String iME=rs.getString("Ime");
			String pREZIME= rs.getString("Prezime");
			String tELEFON= rs.getString("Telefon");
			
			textZaPostavljenje= textZaPostavljenje+ " "+iDSTUDENT+" "+iME;
			
			//i ovo nam ne treba za textArea
			student st=new student(iDSTUDENT,iME ,pREZIME,tELEFON);// ime isto kao i u promenjivoj kao i u kontruktoru					
			dl.addElement(st);
		}
		
		
		
		//i ovo nam ne treba za textArea
		( listaStudenata).setModel(dl);
		
	}	
	
	public void PopuniPredmeteZaStudenta() throws SQLException {
		
		int ID=listaStudenata.getSelectedValue().getIDSTUDENT();
		
		KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
		Connection con=KONEKCIJA.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
		
		//ova komadna uzima sve klijente iz baze
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT predmet.IDPredmet, pr.NazivPredmeta, pr.OpisPredmeta, pr.BrojCasova, pr.ImeProfesora \r\n" + 
				"FROM student as st\r\n" + 
				"INNER JOIN student_predmet as sp on st.IDStudent=sp.IDStudent\r\n" + 
				"INNER join predmet as pr on pr.IDPredmet=sp.IDPredmet\r\n" + 
				"where st.IDStudent=?");
		
		ps.setInt(1,ID);
			
		//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
		ResultSet rs=ps.executeQuery();
		
		DefaultListModel dl=new DefaultListModel();
		
while (rs.next()) {
			
			int IDpredmet=rs.getInt("IDPredmet");  //"ID"mora da bude isto kao i u Bazi			
			String NazivPredmeta=rs.getString("NazivPredmeta");
			String OpisPredmeta= rs.getString("OpisPredmeta");
			int brojCasova= rs.getInt("BrojCasova");
			String imeProfesora= rs.getString("ImeProfesora");
			
			
			//i ovo nam ne treba za textArea
			predmet pr=new predmet(IDpredmet, NazivPredmeta, OpisPredmeta, brojCasova, imeProfesora);
			dl.addElement(pr);
		}
		listaPredmeta.setModel(dl);
		
		
		
		
		
		
}
}