package Project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;

public class StartPage {

	private JFrame frmAlgorithmSimulator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thread.sleep(4000);
					StartPage window = new StartPage();
					window.frmAlgorithmSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}
	
	void SetLook()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//SetLook();
		frmAlgorithmSimulator = new JFrame();
		frmAlgorithmSimulator.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmAlgorithmSimulator.setTitle("Algorithm Simulator");
		frmAlgorithmSimulator.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Important\\Level 2\\CSE Level-2 Term-2\\[Java]\\Exercise\\Algorithm Simulation\\img\\As.png"));
		frmAlgorithmSimulator.getContentPane().setBackground(Color.DARK_GRAY);
		frmAlgorithmSimulator.setBounds(100, 100, 700, 500);
		frmAlgorithmSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgorithmSimulator.setResizable(false);
		frmAlgorithmSimulator.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmAlgorithmSimulator.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		JLabel lblAlgorithmSimulator = new JLabel("Algorithm Simulator");
		panel.add(lblAlgorithmSimulator);
		lblAlgorithmSimulator.setForeground(new Color(255, 255, 102));
		lblAlgorithmSimulator.setBackground(Color.GRAY);
		lblAlgorithmSimulator.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		frmAlgorithmSimulator.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		
		JButton btnExit = new JButton("Exit");
		panel_1.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.DARK_GRAY);
		btnExit.setBackground(Color.GRAY);
		btnExit.setFont(new Font("Stencil", Font.PLAIN, 18));
		
		JButton btnNext = new JButton("Next");
		panel_1.add(btnNext);
		btnNext.setForeground(Color.DARK_GRAY);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAlgorithmSimulator.dispose();
				MainWindow m = new MainWindow();
				m.setVisible(true);
			}
		});
		btnNext.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnNext.setBackground(Color.GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 102));
		frmAlgorithmSimulator.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(51, 51, 51));
		label.setBounds(402, 35, 230, 230);		panel_2.add(label);
		
		Image img = new ImageIcon(this.getClass().getResource("/AlgorithmSimulator.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JButton btnAbout = new JButton("About");
		btnAbout.setBounds(620, 360, 74, 23);
		panel_2.add(btnAbout);
		btnAbout.setFont(new Font("Siyam Rupali", Font.PLAIN, 13));
		btnAbout.setForeground(Color.DARK_GRAY);
		btnAbout.setBackground(Color.GRAY);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(51, 51, 51), new Color(255, 255, 255), new Color(153, 153, 153)));
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(52, 50, 293, 215);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblbellmanFord = new JLabel("3. Bellman Ford");
		lblbellmanFord.setBounds(100, 148, 137, 30);
		panel_3.add(lblbellmanFord);
		lblbellmanFord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblbellmanFord.setForeground(new Color(255, 0, 0));
		lblbellmanFord.setBackground(new Color(204, 0, 0));
		
		JLabel lblDfs = new JLabel("2. DFS");
		lblDfs.setBounds(100, 120, 74, 30);
		panel_3.add(lblDfs);
		lblDfs.setBackground(new Color(204, 0, 0));
		lblDfs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDfs.setForeground(new Color(255, 0, 0));
		
		JLabel lblBfs = new JLabel("1. BFS");
		lblBfs.setBounds(100, 92, 74, 30);
		panel_3.add(lblBfs);
		lblBfs.setBackground(new Color(204, 0, 0));
		lblBfs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBfs.setForeground(new Color(255, 0, 0));
		
		JLabel lblGraph = new JLabel("Graph ");
		lblGraph.setBounds(58, 53, 88, 36);
		panel_3.add(lblGraph);
		lblGraph.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGraph.setForeground(Color.ORANGE);
		
		JLabel lblItemsThatIt = new JLabel("Items that it contains:");
		lblItemsThatIt.setBounds(11, 0, 226, 42);
		panel_3.add(lblItemsThatIt);
		lblItemsThatIt.setForeground(Color.YELLOW);
		lblItemsThatIt.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmAlgorithmSimulator, "Mahadi Hassan Munna\n  201714032\nDip Dipu\n  201714021\nMIST", "About", 1);
			}
		});
		
	}
}

