import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class GlavnaKlasa extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		/* STEKOVI
		Stack<Integer> nasStack=new Stack<Integer>();
		
		nasStack.push(5);//push je stavljanje vrednosti na stek
		nasStack.push(10);
		nasStack.push(77);
		
		//LIFO = last in first out (koga poslednjed dodamo on ide prvi napolje)
		System.out.println(nasStack.pop());// pop je skidanje vrednosti sa steka
		System.out.println(nasStack.pop());
		System.out.println(nasStack.pop());
		
		
		//FIFO - FIRST IN, FIRST OUT, onaj koji je prvi dosao on je prvi izasao
		Queue<Integer> nasRed=new LinkedList<Integer>();
		nasRed.add(10);
		nasRed.add(25);
		
		System.out.println(nasRed.remove());
		*/
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavnaKlasa frame = new GlavnaKlasa();
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
	public GlavnaKlasa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDodaj_Predmet = new JButton("DODAJ  PREDMET");
		btnDodaj_Predmet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DODAJPREDMET dp=new DODAJPREDMET();
				dp.setVisible(true);
			
			}
		});
		btnDodaj_Predmet.setBounds(10, 23, 196, 59);
		contentPane.add(btnDodaj_Predmet);
		
		JButton btnDodaj_Studenta = new JButton("DODAJ  STUDENTA");
		btnDodaj_Studenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DODAJ_STUDENTA ds=new DODAJ_STUDENTA();
				ds.setVisible(true);
			}
		});
		btnDodaj_Studenta.setBounds(10, 112, 196, 59);
		contentPane.add(btnDodaj_Studenta);
		
		JButton btnLISTA_STUDENATA = new JButton("LISTA  STUDENATA");
		btnLISTA_STUDENATA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LISTA_STUDENATA ls=new LISTA_STUDENATA();
				ls.setVisible(true);
			}
		});
		btnLISTA_STUDENATA.setBounds(10, 303, 196, 23);
		contentPane.add(btnLISTA_STUDENATA);
		
		JButton btnLISTA_PREDMETA = new JButton("LISTA  PREDMETA");
		btnLISTA_PREDMETA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LISTA_PREDMETA lp=new LISTA_PREDMETA();
				lp.setVisible(true);
			}
		});
		btnLISTA_PREDMETA.setBounds(10, 365, 196, 23);
		contentPane.add(btnLISTA_PREDMETA);
	}
}
