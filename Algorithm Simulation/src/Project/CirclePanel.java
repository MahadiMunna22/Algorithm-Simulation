package Project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import java.awt.Color;

public class CirclePanel extends Panel {
	int i, j ;
	int x1;
	int x2;
	int y1;
	int y2;
	int weight;
	Color color;
	int x[] = new int[100];
	int y[] = new int[100];
	
	
	public CirclePanel() {
		setBackground(Color.BLACK);
	}
	
	private List<Circle> circles = new ArrayList<Circle>();
	
	public void addCircle(Circle circle)
	{
		i = circles.size();
		j = circle.getNodeNum();
		circles.add(circle);
		x[j] = circle.getX();
		y[j] = circle.getY();
		this.repaint();
	}

	public boolean IsEmpty()
	{
		if(circles.isEmpty()==true)
			return true;
		else
			return false;
	}
	void addEdge(int x1, int x2, int y1, int y2, String z, int weight, Color color)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.weight = weight;
		this.color = color;
		Draw(getGraphics(),color, z);
		File click = new File("sound/Click1.wav");
		MainWindow m = new MainWindow();
		if(m.addSound == true)
		{
			playSound(click);
		}
	}
	
	
	void Draw (Graphics g, Color c, String z)
	{
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.YELLOW);
		g.drawString(z, (x1+x2+x1)/3, (y1+y2+y1)/3);
	}
	
	public void paint(Graphics g) {
		for(Circle c: circles)
		{
			c.draw(g);
		}
	}
	public void playSound(File sound)
	{
		try {
			Clip clip;
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
