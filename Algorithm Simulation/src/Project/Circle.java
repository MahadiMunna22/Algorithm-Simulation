package Project;

import java.awt.Color;
import java.awt.Graphics;

public class Circle 
{
	private int x;
	private int y;
	private int diameter;
	private Color color;
	private int i1;
	
	public Circle(int x, int y, int diameter, Color color, int i1) 
	{
		super();
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
		this.i1 = i1;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDiameter() {
		return diameter;
	}

	public Color getColor() 
	{
		return color;
	}
	public int getNodeNum()
	{
		return i1;
	}
	
	
	public void draw (Graphics g)
	{
		String i2 = String.valueOf(i1);
		g.setColor(getColor());
		g.fillOval(x, y, diameter, diameter);
		g.setColor(Color.BLUE);
		g.drawString(i2, x+20, y+20);
	}
	
}
