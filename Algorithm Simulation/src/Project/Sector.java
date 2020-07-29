package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Window.Type;
import javax.swing.BoxLayout;

public class Sector extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	File button = new File("sound/button.wav");

	int g = 0, h = 0, p = 0, l = 0;
	static int X[] = new int[100], Y[] = new int[100];
	static int e1[] = new int[100], e2[] = new int[100], wgt[] = new int [100],w[] = new int[100];
	static int n, x1[] = new int[100], y1[] = new int[100], x2[] = new int[100], y2[] = new int[100]; 
	static int i ;
	static String z[] = new String[100];
	static boolean BFS_Visited;
	static boolean DFS_Visited;
	static boolean Bellman_Visited;
	private JTextField Enter_Src;
	static String s = null;
	static int S;
	static int [] bellmanValue = new int [100];
	static boolean addSound = true;
	void Addcircle(ArrayList a1, ArrayList a2, int i)
	{
		X[i] = (int) a1.get(i);
		Y[i] = (int) a2.get(i);
		n = a1.size();
	}
	void AddEdge(int a, int b,int X1,int X2,int Y1,int Y2,String Z,int W, int k)
	{
		e1[k] = a;
		e2[k] = b;
		
		x1[k] = X1;
		y1[k] = Y1;
		x2[k] = X2;
		y2[k] = Y2;
		z[k] = Z;
		wgt[k] = W;
		i = k;
	}
	
	public Sector() {
		setType(Type.POPUP);
		
		setTitle("Algorithm Simulator");
		setIconImage(new ImageIcon(this.getClass().getResource("/As.png")).getImage());
		
		CirclePanel Panel1 = new CirclePanel();
		Panel1.setBackground(new Color(0, 200, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,730,600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		//setResizable(false);
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 153));
		panel.add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, null, new Color(255, 255, 255), null));
		panel_5.setBackground(new Color(30, 144, 255));
		Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(153, 204, 153));
		panel.add(panel_14, BorderLayout.WEST);
		panel_14.setVisible(false);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(153, 204, 153));
		panel_15.setVisible(false);
		
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		for(int j = 0; j<n; j++)
		{
			Circle c = new Circle(X[j], Y[j], 40, Color.GREEN, j);
			Panel1.addCircle(c);
		}
		
		//------------------Back Button---------------------
		
		JButton btnBack = new JButton("Back");
		panel_5.add(btnBack);
		btnBack.setIcon(new ImageIcon("F:\\Important\\Level 2\\CSE Level-2 Term-2\\[Java]\\Exercise\\Algorithm Simulation\\img\\back.png"));
		btnBack.setBackground(new Color(144, 238, 144));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addSound == true)
				{
					playSound(button);
				}
				dispose();
				MainWindow m = new MainWindow();
				m.setVisible(true);
			}
		});
		panel_1.setBackground(new Color(0, 102, 51));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 153));
		panel_1.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setForeground(new Color(245, 245, 245));
		lblAlgorithms.setFont(new Font("Tahoma", Font.PLAIN, 33));
		panel_4.add(lblAlgorithms);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(153, 204, 153));
		panel_1.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 102, 51));
		panel_11.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(153, 204, 153));
		panel_16.setVisible(false);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		panel_12.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 102, 153));
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.RED);
		panel_7.setBackground(new Color(102, 204, 153));
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, Color.WHITE, Color.LIGHT_GRAY));
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		BFS b = new BFS(n);
		DFS d = new DFS(n);
		BellmanFord bell = new BellmanFord(n+1, i+1);
		
		//-----------------------Next--------------------------
		
		JButton btnNextStep = new JButton("Next Step");
		btnNextStep.setVisible(false);
		btnNextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addSound == true)
				{
					playSound(button);
				}
				p = 0;
				if(BFS_Visited == true && b.z!=g)
				{
					
					int index = b.arr1.get(g);
					String color = b.arr2.get(g);
					if(color=="W")
					{
						Circle c1 = new Circle(X[index], Y[index], 40, Color.WHITE,index);
						Panel1.addCircle(c1);
						//System.out.println(index+" :"+color);
					}
					else if(color=="G")
					{
						Circle c2 = new Circle(X[index], Y[index], 40, Color.GRAY,index);
						Panel1.addCircle(c2);
						//System.out.println(index+" :"+color);
					}
					else if(color=="B")
					{
						Circle c3 = new Circle(X[index], Y[index], 40, Color.BLACK,index);
						Panel1.addCircle(c3);
						//System.out.println(index+" :"+color);
					}
					g++;
				}
				else if(DFS_Visited == true && d.z!=h)
				{
					int index = d.arr1.get(h);
					String color = d.arr2.get(h);
					if(color=="W")
					{
						Circle c1 = new Circle(X[index], Y[index], 40, Color.WHITE,index);
						Panel1.addCircle(c1);
						//System.out.println(index+" :"+color);
					}
					else if(color=="G")
					{
						Circle c2 = new Circle(X[index], Y[index], 40, Color.GRAY,index);
						Panel1.addCircle(c2);
						//System.out.println(index+" :"+color);
					}
					else if(color=="B")
					{
						Circle c3 = new Circle(X[index], Y[index], 40, Color.BLACK,index);
						Panel1.addCircle(c3);
						//System.out.println(index+" :"+color);
					}
					
					h++;
				}
				else if(Bellman_Visited == true)
				{
					//System.out.println("H: "+bellmanValue);
					if(l<n && l!=S)
					{
						int w1 ;
						int w2 ;
						int q1 ;
						int q2 ;
						w1 = Panel1.x[S]+20;
						q1 = Panel1.y[S]+20;
						w2 = Panel1.x[l]+20;
						q2 = Panel1.y[l]+20;
						{
							Panel1.addEdge(w1, w2, q1, q2, String.valueOf(bellmanValue[l]), bellmanValue[l], Color.red);
							System.out.println("H: "+bellmanValue[l]);
						}
					}
					l++;
				}
				
			}
		});
		
		//--------------------------BFS------------------------------
		
		JButton btnBfs = new JButton("BFS");
		btnBfs.setSelectedIcon(null);
		panel_7.add(btnBfs);
		btnBfs.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBfs.setForeground(SystemColor.window);
		btnBfs.setBackground(new Color(102, 204, 153));
		btnBfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(addSound == true)
				{
					playSound(button);
				}
				Image img = new ImageIcon(this.getClass().getResource("/BFS.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
				label.setBounds(0, 0, 413, 496);
				btnNextStep.setVisible(true);
				for(int m = 0; m<=i;m++)
				{
					b.Add_edge(e1[m], e2[m]);
				}
				b.BFS(0);
				BFS_Visited = true;
				DFS_Visited = false;
				Bellman_Visited = false;
				panel_15.setVisible(true);
				panel_14.setVisible(true);
				panel_16.setVisible(false);
				panel_12.setVisible(true);
			}
		});
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(102, 204, 153));
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, Color.WHITE, Color.LIGHT_GRAY));
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		//-------------------------DFS-----------------------------
		
		JButton btnDfs = new JButton("DFS");
		panel_8.add(btnDfs);
		btnDfs.setFont(new Font("Dialog", Font.BOLD, 12));
		btnDfs.setBackground(new Color(102, 204, 153));
		btnDfs.setForeground(SystemColor.window);
		btnDfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addSound == true)
				{
					playSound(button);
				}
				//label.removeAll();
				Image img = new ImageIcon(this.getClass().getResource("/DFS.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
				label.setBounds(0, 0, 413, 496);
				btnNextStep.setVisible(true);
				for(int m = 0; m<=i;m++)
				{
					d.Add_edge(e1[m], e2[m]);
				}
				d.DFS();
				DFS_Visited = true;
				BFS_Visited = false;
				Bellman_Visited = false;
				panel_15.setVisible(true);
				panel_14.setVisible(true);
				panel_16.setVisible(false);
				panel_12.setVisible(true);
			}
		});
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(102, 204, 153));
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, Color.WHITE, Color.LIGHT_GRAY));
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnBellMan = new JButton("BellManFord");
		panel_9.add(btnBellMan);
		btnBellMan.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBellMan.setBackground(new Color(102, 204, 153));
		btnBellMan.setForeground(SystemColor.window);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_6.add(panel_7);
		panel_6.add(panel_8);
		panel_6.add(panel_9);
		panel_6.add(panel_10);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(188)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(8)
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(5)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_18.setLayout(new CardLayout(0, 0));
		
		JButton start = new JButton("");
		JButton stop = new JButton("");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSound = true;
				start.setVisible(true);
				stop.setVisible(false);
			}
		});
		panel_18.add(start, "name_6728453994523");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSound = false;
				start.setVisible(false);
				stop.setVisible(true);
			}
		});
		start.setIcon(new ImageIcon("img/start.png"));
		stop.setIcon(new ImageIcon("img/stop.png"));
		
		panel_18.add(stop, "name_6728472703439");
		panel_2.setLayout(gl_panel_2);
		
		//--------------------------bellman-----------------------------
		
		btnBellMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_15.setVisible(false);
				panel_14.setVisible(true);
				panel_16.setVisible(true);
				panel_12.setVisible(true);
				if(addSound == true)
				{
					playSound(button);
				}
				
				//label.removeAll();
				Image img = new ImageIcon(this.getClass().getResource("/Bellman.jpg")).getImage();
				label.setIcon(new ImageIcon(img));
				label.setBounds(0, 0, 413, 496);
				for(int m = 0; m<= i; m++)
				{
					bell.addedge(m, e1[m], e2[m], wgt[m]);
				}
				btnNextStep.setVisible(true);
				Bellman_Visited = true;
				BFS_Visited = false;
				DFS_Visited = false;
				
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 102, 51));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3.add(Panel1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 715, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
		);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(0, 102, 153));
		panel.add(panel_13, BorderLayout.SOUTH);
		btnNextStep.setForeground(new Color(204, 255, 204));
		btnNextStep.setBackground(new Color(0, 102, 51));
		
		//---------------------Restart-----------------------------
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setForeground(new Color(153, 255, 153));
		btnRestart.setBackground(new Color(51, 51, 153));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addSound == true)
				{
					playSound(button);
				}
				
				for(int j = 0; j<n; j++)
				{
					Circle c = new Circle(X[j], Y[j], 40, Color.GREEN, j);
					Panel1.addCircle(c);
				}
				l = 0;
				g = 0;
				h = 0;
				p = 0;
				s = null;
				BFS_Visited = false;
				DFS_Visited = false;
				Bellman_Visited = false;
				panel_14.setVisible(false);
				btnNextStep.setVisible(false);
				panel_12.setVisible(false);
			}
		});
		
		//---------------------Add Edge-------------------------------
		
		JButton btnAddEdge = new JButton("Add Edge");
		btnAddEdge.setForeground(SystemColor.menu);
		btnAddEdge.setBackground(new Color(0, 102, 51));
		
		btnAddEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(p<=i)
				{
					Panel1.addEdge(x1[p], x2[p], y1[p], y2[p], z[p] , w[p], Color.red);
				}
				p++;
			}
		});
		panel_13.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_13.add(btnRestart);
		panel_13.add(btnAddEdge);
		panel_13.add(btnNextStep);
		
		
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_14.createSequentialGroup()
							.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_15, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_16, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(267, Short.MAX_VALUE))
		);
		panel_16.setLayout(null);
		
		
		
		
		JLabel lblEnterSource = new JLabel("Enter Source: ");
		lblEnterSource.setBounds(0, 0, 90, 35);
		panel_16.add(lblEnterSource);
		
		Enter_Src = new JTextField();
		Enter_Src.setBounds(108, 7, 40, 20);
		panel_16.add(Enter_Src);
		Enter_Src.setColumns(10);
		
		//-----------------------Set--------------------------
		
		JButton btnSet = new JButton("Set");
		btnSet.setForeground(new Color(153, 204, 153));
		btnSet.setBackground(new Color(0, 102, 51));
		btnSet.setBounds(93, 41, 55, 23);
		panel_16.add(btnSet);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = Enter_Src.getText();
				S = Integer.valueOf(s);
				bell.BellmanFord(S);
				bellmanValue = BellmanFord.sp;
			}
		});
		panel_15.setLayout(null);
		
		JLabel lblNotVisitedWhite = new JLabel("Not Discovered:");
		lblNotVisitedWhite.setBounds(0, 26, 100, 14);
		panel_15.add(lblNotVisitedWhite);
		
		JLabel lblWhite = new JLabel("WHITE");
		lblWhite.setBounds(101, 26, 52, 14);
		panel_15.add(lblWhite);
		lblWhite.setForeground(new Color(255, 255, 255));
		
		JLabel lblDiscovered = new JLabel("Discovered: ");
		lblDiscovered.setBounds(0, 51, 86, 25);
		panel_15.add(lblDiscovered);
		
		JLabel lblGrey = new JLabel("GREY");
		lblGrey.setBounds(101, 56, 52, 15);
		panel_15.add(lblGrey);
		lblGrey.setForeground(Color.GRAY);
		
		JLabel lblExplored = new JLabel("Explored: ");
		lblExplored.setBounds(0, 87, 81, 22);
		panel_15.add(lblExplored);
		
		JLabel lblBlack = new JLabel("BLACK");
		lblBlack.setBounds(101, 88, 52, 20);
		panel_15.add(lblBlack);
		
		JLabel lblcolor = new JLabel("--Color--");
		lblcolor.setBounds(50, -8, 50, 30);
		panel_15.add(lblcolor);
		panel_14.setLayout(gl_panel_14);
		
		JPanel panel_17 = new JPanel();
		panel.add(panel_17, BorderLayout.EAST);
		
		JButton button_2 = new JButton("<");
		button_2.setBackground(new Color(0, 102, 153));
		JButton button_1 = new JButton(">");
		button_1.setBackground(new Color(0, 102, 153));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(true);
				button_2.setVisible(true);
				button_1.setVisible(false);
				setSize(1160,600);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				button_2.setVisible(false);
				button_1.setVisible(true);
				
				setSize(730,600);
			}
		});
		panel_17.setLayout(new CardLayout(0, 0));
		panel_17.add(button_1, "name_9013062608172");
		panel_17.add(button_2, "name_9013079127672");
		button_2.setVisible(false);
		
		
		
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
	}
	public void playSound(File sound)
	{
		try {
			Clip clip;
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
