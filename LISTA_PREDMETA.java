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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JTextArea;
import javax.swing.JList;

public class LISTA_PREDMETA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LISTA_PREDMETA frame = new LISTA_PREDMETA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LISTA_PREDMETA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    list = new JList();
		list.setBounds(0, 11, 340, 408);
		contentPane.add(list);
				
					try {
						popuniListuIzBaze();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		public void popuniListuIzBaze() throws SQLException {
				
				KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
				Connection con=KONEKCIJA.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
				
				//ova komadna uzima sve klijente iz baze
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from predmet");
					
				//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
				ResultSet rs=ps.executeQuery();
				
				DefaultListModel dl=new DefaultListModel();
				
				while (rs.next()) {
					
					int iDPREDMET=rs.getInt("IDPredmet");  //"ID"mora da bude isto kao i u Bazi			
					String nAZIV_PREDMETA=rs.getString("NazivPredmeta");
					String oPIS_PREDMETA= rs.getString("OpisPredmeta");
					int bROJ_CASOVA= rs.getInt("BrojCasova");
					String iME_PROFESORA= rs.getString("ImeProfesora");
					predmet pr=new predmet(iDPREDMET,nAZIV_PREDMETA ,oPIS_PREDMETA,bROJ_CASOVA,iME_PROFESORA);// ime isto kao i u promenjivoj kao i u kontruktoru
					
			dl.addElement(pr);
				}
			
				( list).setModel(dl);
		
		}
}
