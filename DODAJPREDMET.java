import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class DODAJPREDMET extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNaziv_Predmeta;
	private JTextArea textOpis_Predmeta;
	private JTextField textIme_Profesora;
	private JTextField textBroj_Casova;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DODAJPREDMET frame = new DODAJPREDMET();
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
	public DODAJPREDMET() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNaziv_Predmeta = new JLabel("NAZIV  PREDMETA");
		lblNaziv_Predmeta.setBounds(10, 11, 229, 14);
		contentPane.add(lblNaziv_Predmeta);
		
		textNaziv_Predmeta = new JTextField();
		textNaziv_Predmeta.setBounds(10, 33, 229, 20);
		contentPane.add(textNaziv_Predmeta);
		textNaziv_Predmeta.setColumns(10);
		
		JLabel lblOpis_Predmeta = new JLabel("OPIS  PREDMETA");
		lblOpis_Predmeta.setBounds(10, 85, 229, 14);
		contentPane.add(lblOpis_Predmeta);
		
	    textOpis_Predmeta = new JTextArea();
		textOpis_Predmeta.setBounds(10, 108, 229, 94);
		contentPane.add(textOpis_Predmeta);
	
		
		
		
		
		JLabel lblBroj_Casova = new JLabel("BROJ  \u010CASOVA");
		lblBroj_Casova.setBounds(10, 232, 229, 14);
		contentPane.add(lblBroj_Casova);
		
		textBroj_Casova = new JTextField();
		textBroj_Casova.setBounds(10, 257, 229, 20);
		contentPane.add(textBroj_Casova);
		textBroj_Casova.setColumns(10);
		
		JLabel lblIme_Profesora = new JLabel("IME  PROFESORA");
		lblIme_Profesora.setBounds(10, 306, 229, 14);
		contentPane.add(lblIme_Profesora);
		
		textIme_Profesora = new JTextField();
		textIme_Profesora.setBounds(10, 331, 229, 20);
		contentPane.add(textIme_Profesora);
		textIme_Profesora.setColumns(10);
		
		JButton btnDODAJ_PREDMET = new JButton("DODAJ  PREDMET");
		btnDODAJ_PREDMET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 KONEKCIJA kon=new KONEKCIJA();
					 Connection con=KONEKCIJA.otvoriKONEKCIJU();
					 
					 PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into predmet(NazivPredmeta,OpisPredmeta,BrojCasova,ImeProfesora)values(?,?,?,?)");
					 ps.setString(1,textNaziv_Predmeta.getText());
					 ps.setString(2,textOpis_Predmeta.getText());
					 ps.setString(3,textBroj_Casova.getText());//konverzija Stringa u Integer
					 ps.setString(4,textIme_Profesora.getText());
					 
					 
					 ps.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnDODAJ_PREDMET.setBounds(10, 393, 229, 50);
		contentPane.add(btnDODAJ_PREDMET);
		
		
	}
}
