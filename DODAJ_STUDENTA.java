 import java.awt.BorderLayout;
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

public class DODAJ_STUDENTA extends JFrame {

	private JPanel contentPane;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textTelefon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DODAJ_STUDENTA frame = new DODAJ_STUDENTA();
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
	public DODAJ_STUDENTA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("IME");
		lblIme.setBounds(24, 11, 165, 14);
		contentPane.add(lblIme);
		
		textIme = new JTextField();
		textIme.setBounds(24, 37, 189, 20);
		contentPane.add(textIme);
		textIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("PREZIME");
		lblPrezime.setBounds(24, 82, 249, 14);
		contentPane.add(lblPrezime);
		
		textPrezime = new JTextField();
		textPrezime.setBounds(24, 107, 189, 20);
		contentPane.add(textPrezime);
		textPrezime.setColumns(10);
		
		JLabel lblTelefon = new JLabel("TELEFON");
		lblTelefon.setBounds(24, 163, 189, 14);
		contentPane.add(lblTelefon);
		
		textTelefon = new JTextField();
		textTelefon.setBounds(24, 188, 189, 20);
		contentPane.add(textTelefon);
		textTelefon.setColumns(10);
		
		JButton btnDodaj_Studenta = new JButton("DODAJ  STUDENTA");
		btnDodaj_Studenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 KONEKCIJA kon=new KONEKCIJA();
					 Connection con=KONEKCIJA.otvoriKONEKCIJU();
					 
					 PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into student(Ime,Prezime,Telefon)values(?,?,?)");
					 ps.setString(1,textIme.getText());
					 ps.setString(2,textPrezime.getText());
					 ps.setString(3,textTelefon.getText());//konverzija Stringa u Integer
					
					 
					 
					 ps.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Uspesno dodato u bazu");
				 } catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDodaj_Studenta.setBounds(27, 245, 246, 47);
		contentPane.add(btnDodaj_Studenta);
	}
}
