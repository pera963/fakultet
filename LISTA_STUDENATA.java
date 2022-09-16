import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ComponentListener;
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


import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;

public class LISTA_STUDENATA extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JList list;
	JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LISTA_STUDENATA frame = new LISTA_STUDENATA();
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
	public LISTA_STUDENATA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		list = new JList();
		list.setBounds(10, 31, 424, 285);
		contentPane.add(list);	
		list.addListSelectionListener(new ListSelectionListener() {
			
			
				
			
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		//LISTA_STUDENATA.addComponentListener((ComponentListener) new AncestorListener() {
			
		//	public void ancestorAdded(AncestorEvent event) {
	      // }
	    //	public void ancestorMoved(AncestorEvent event) {
	    //	}
	    //	public void ancestorRemoved(AncestorEvent event) {
	    //	}
	     //  });
		list.setBounds(10, 31, 553, 282);
					
					
					contentPane.add(list);
					
					 textArea = new JTextArea();
					textArea.setBounds(20, 362, 543, 42);
					contentPane.add(textArea);
				
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
				PreparedStatement ps=(PreparedStatement) con.prepareStatement("Select * from student");
					
				//Kada smo podatke iz baze smestamo ih u ResultSet (to je tip promenjive za smestanje podataka iz baze)
				ResultSet rs=ps.executeQuery();
				
				DefaultListModel dl=new DefaultListModel();// to ne ide ako pravimo samo textArea jer nemamo listu
				
				String textZaPostavljenje="";
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
				
				textArea.setText(textZaPostavljenje);
				
				//i ovo nam ne treba za textArea
				( list).setModel(dl);
				
			
		}
		}

