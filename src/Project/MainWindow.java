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
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;

public class MainWindow extends JFrame {

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

	/**
	 * Create the frame.
	 */
	//
	
	String i1 ;
	String K1,K2,K3;
	int x1,y1,x2,y2,k1,k2,k3;
	int [] a = new int[1000];
	int [] b = new int[1000];
	int i = 0;
	
	
	private JTextField Txt1stNode;
	private JTextField Txt2ndNode;
	private JTextField EdgeValue;
	static boolean addSound = true;
	
	File sound()
	{
		File button = new File("sound/button.wav");
		return button;
	}
	
	public MainWindow() {
		
		setTitle("Algorithm Simulator");
		setIconImage(new ImageIcon(this.getClass().getResource("/As.png")).getImage());
		
		CirclePanel Panel = new CirclePanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 575);
		contentPane = new JPanel();
		setContentPane(contentPane);
		//setResizable(false);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(64, 64, 64), SystemColor.info, new Color(64, 64, 64)));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, new Color(0, 255, 255), new Color(64, 64, 64), new Color(255, 255, 255)));
		panel_1.setBackground(new Color(95, 158, 160));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JButton btnTakeEdge = new JButton("       Start taking Edge     ");
		btnTakeEdge.setForeground(new Color(0, 0, 0));
		btnTakeEdge.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		btnTakeEdge.setBackground(new Color(0, 102, 255));
		
		JLabel label1 = new JLabel("");
		label1.setBackground(SystemColor.textHighlight);
		label1.setForeground(SystemColor.desktop);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTakeEdge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(23))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addComponent(btnTakeEdge, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.CYAN, Color.DARK_GRAY, Color.WHITE));
		panel_3.setBackground(new Color(95, 158, 160));
		panel_2.add(panel_3);
		
		Txt1stNode = new JTextField();
		Txt1stNode.setColumns(10);
		Txt1stNode.setVisible(false);
		
		Txt2ndNode = new JTextField();
		Txt2ndNode.setColumns(10);
		Txt2ndNode.setVisible(false);
		
		JLabel lbl1stNode = new JLabel("1st Node");
		lbl1stNode.setForeground(new Color(255, 255, 51));
		lbl1stNode.setVisible(false);
		
		JLabel lbl2ndNode = new JLabel("2nd Node");
		lbl2ndNode.setForeground(new Color(255, 255, 51));
		lbl2ndNode.setVisible(false);
		
		JButton btnAddEdge = new JButton("Add Edge");
		
		btnAddEdge.setBackground(SystemColor.activeCaption);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(51, 102, 255), new Color(0, 0, 51), new Color(102, 204, 204)));
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNext = new JButton("Next");
		panel_5.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(addSound == true)
				{
					playSound(sound());
				}
				
				dispose();
				
				Sector s = new Sector();
				s.setVisible(true);
			}
		});
		btnNext.setBackground(SystemColor.textHighlight);
		
		JLabel lblEdgeValue = new JLabel("Edge Value: ");
		lblEdgeValue.setForeground(new Color(255, 255, 51));
		lblEdgeValue.setVisible(false);
		
		EdgeValue = new JTextField();
		EdgeValue.setColumns(10);
		EdgeValue.setVisible(false);
		
		JPanel panel_Restart = new JPanel();
		panel_Restart.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(153, 0, 0), new Color(255, 255, 255), new Color(102, 204, 204)));
		panel_Restart.setVisible(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(33)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_3.createSequentialGroup()
											.addComponent(lblEdgeValue, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_3.createSequentialGroup()
											.addComponent(lbl1stNode, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
											.addGap(30))
										.addGroup(gl_panel_3.createSequentialGroup()
											.addComponent(lbl2ndNode, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
										.addComponent(EdgeValue, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
										.addComponent(Txt2ndNode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
										.addComponent(Txt1stNode, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddEdge, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
										.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
										.addComponent(panel_Restart, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
							.addGap(19))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(84))))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(Txt1stNode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl1stNode, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(Txt2ndNode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl2ndNode, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(EdgeValue, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEdgeValue, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAddEdge, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_Restart, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel_6.setLayout(new CardLayout(0, 0));
		
		JButton button = new JButton("");
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSound = false;
				button_1.setVisible(false);
				button.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("img/play_Sound.png"));
		panel_6.add(button_1, "name_1315382456040");
		
		
		button.setIcon(new ImageIcon("img/Pause.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addSound = true;
				button_1.setVisible(true);
				button.setVisible(false);
			}
		});
		panel_6.add(button, "name_2762947371124");
		panel_Restart.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnRestart = new JButton("Restart");
		panel_Restart.add(btnRestart);
		btnRestart.setForeground(new Color(102, 153, 153));
		btnRestart.setBackground(new Color(102, 0, 0));
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow m = new MainWindow();
				m.setVisible(true);
			}
		});
		panel_3.setLayout(gl_panel_3);
		btnAddEdge.setVisible(false);
		
		label1.setVisible(false);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label1, btnTakeEdge}));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		
		
		panel_4.add(Panel); 
		Panel.addMouseListener(new CircleClicked(Panel));
		Panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnTakeEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(addSound == true)
				{
					playSound(sound());
				}
				panel_Restart.setVisible(true);
				Panel.disable();
				i1 = String.valueOf(Panel.i+1);
				label1.setVisible(true);
				Txt1stNode.setVisible(true);
				Txt2ndNode.setVisible(true);
				EdgeValue.setVisible(true);
				lblEdgeValue.setVisible(true);
				lbl1stNode.setVisible(true);
				lbl2ndNode.setVisible(true);
				btnAddEdge.setVisible(true);
				if(Panel.IsEmpty())
					label1.setText("    "+"0 nodes");
				else
					label1.setText("    "+i1+" nodes");
			}
		});
		
		
		
		btnAddEdge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				K1 = Txt1stNode.getText();
				k1 = Integer.valueOf(K1);
				K2 = Txt2ndNode.getText();
				k2 = Integer.valueOf(K2);
				K3 = EdgeValue.getText();
				k3 = Integer.valueOf(K3);
				
				
				x1 = Panel.x[k1]+20;
				y1 = Panel.y[k1]+20;
				x2 = Panel.x[k2]+20;
				y2 = Panel.y[k2]+20;
				
				Panel.addEdge(x1, x2, y1, y2,K3+"("+K1+", "+K2+")",k3, Color.RED);
				a[i] = k1;
				b[i] = k2;
				
				Sector s = new Sector();
				s.AddEdge(a[i], b[i],x1, x2, y1, y2,K3+" ("+K1+", "+K2+")",k3, i);
				//System.out.println(x1+" "+y1+" "+x2+" "+y2);
				i++;
				
			}
			

		});
		
		
		
		
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
