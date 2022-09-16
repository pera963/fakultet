import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class student_predmet extends JFrame {

	private JPanel contentPane;
    private JComboBox comboPREDMETI;
	private JComboBox comboSTUDENTI;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_predmet frame = new student_predmet();
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
	public student_predmet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboSTUDENTI = new JComboBox();
		comboSTUDENTI.setBounds(33, 54, 341, 22);
		contentPane.add(comboSTUDENTI);
		
		comboPREDMETI = new JComboBox();
		comboPREDMETI.setBounds(33, 160, 341, 22);
		contentPane.add(comboPREDMETI);
		
		JButton btnSTUDENT_PREDMET = new JButton("STUDENTI  PREDMETI");
		btnSTUDENT_PREDMET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// odavde mi pišemo	
					KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa naša i mi dajemo Objekat (promenjiva)na klasu kon.
					Connection con=kon.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
					PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into student_predmet(IDStudent,IDPredmet) values(?,?)");
					
					
					// uzimamo celog studenta kog smo selektovali iz comboboxa pacijenti
					student st=(student) comboSTUDENTI.getSelectedItem();
					
					//Kastovanje je "pojašnjenje"koji tip objekta je selektovao combobox
					//u temp promenjivoj èuvam selektovanog klijenta
					
					//u bazi ubacujemo samo ID tog klijenta (pacijenta)
					ps.setInt(1, st.getIDSTUDENT()); //ubacujem u bazu ID klijenta koga sam selektovao
					
					 predmet pr= (predmet)comboPREDMETI.getSelectedItem();
					ps.setInt(2,pr.getIDPREDMET());
					
					ps.executeUpdate();//za umetanje,ažuriranje i brisanje redova u tim tabelama i vraæa æelobrojnu vrednost tj. br redova 					
					
					JOptionPane.showMessageDialog(null, " uspesno dodato u bazu ");//dugme
					// dovde smo pisali
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}								
		});
		
		btnSTUDENT_PREDMET.setBounds(34, 275, 340, 50);
		contentPane.add(btnSTUDENT_PREDMET);
		
		JLabel lblSTUDENTI = new JLabel("STUDENTI");
		lblSTUDENTI.setBounds(33, 26, 219, 14);
		contentPane.add(lblSTUDENTI);
		
		JLabel lblPREDMETI = new JLabel("PREDMETI");
		lblPREDMETI.setBounds(33, 125, 219, 14);
		contentPane.add(lblPREDMETI);
		PopuniComboStudenti();
		PopuniComboPredmeti();
	
	}

public void PopuniComboPredmeti() {
	
	try {
		//Konekcijja na bazu
	KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
	Connection con=KONEKCIJA.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
	
	//ova komadna uzima sve doktore iz baze
	PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from predmet");
		
	//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
	ResultSet rs=ps.executeQuery();
			
	//pravimo model koji cemo popunjavati sa doktorima iz baze a posle vezati za COMBOBOX
	//ovo je isto kao sto smo radili za listu
	DefaultComboBoxModel dml= new DefaultComboBoxModel();//to je lista comboboxa ne treba lista
	
	while (rs.next()) {
		// uzimamo jednog po jednog doktora

		int iDPREDMET=rs.getInt("IDPredmet");  //"ID"mora da bude isto kao i u Bazi			
		String nAZIV_PREDMETA=rs.getString("NazivPredmeta");
		String oPIS_PREDMETA= rs.getString("OpisPredmeta");
		int bROJ_CASOVA= rs.getInt("BrojCasova");
		String iME_PROFESORA= rs.getString("ImeProfesora");
		
		predmet pr=new predmet(iDPREDMET,nAZIV_PREDMETA ,oPIS_PREDMETA,bROJ_CASOVA,iME_PROFESORA);// ime isto kao i u promenjivoj kao i u kontruktoru
		
		dml.addElement(pr);		
	}
		comboPREDMETI.setModel(dml);
	
	}catch (Exception e) {
	}	
    }
public void PopuniComboStudenti() {
	
	try {
		//Konekcijja na bazu
	KONEKCIJA kon=new KONEKCIJA();//pravimo konekciju na bazu,Konekcija clasa je naša i mi dajemo Objekat (promenjiva)na klasu kon.
	Connection con=KONEKCIJA.otvoriKONEKCIJU();//Connection to je Javina clasa,con varijabla tipa Connection  
	
	//ova komadna uzima sve doktore iz baze
	PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from student");
		
	//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
	ResultSet rs=ps.executeQuery();
			
	//pravimo model koji cemo popunjavati sa doktorima iz baze a posle vezati za COMBOBOX
	//ovo je isto kao sto smo radili za listu
	DefaultComboBoxModel dml= new DefaultComboBoxModel();//to je lista comboboxa ne treba lista
	
	while (rs.next()) {
		int iDSTUDENT=rs.getInt("IDStudent");  //"ID"mora da bude isto kao i u Bazi			
		String iME=rs.getString("Ime");
		String pREZIME= rs.getString("Prezime");
		String tELEFON= rs.getString("Telefon");
		
		student st=new student(iDSTUDENT,iME ,pREZIME,tELEFON);
		
		dml.addElement(st);		
	}
		comboSTUDENTI.setModel(dml);
	
	}catch (Exception e) {
	}	
    }
    }