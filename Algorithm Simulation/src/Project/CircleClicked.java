package Project;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class CircleClicked extends MouseAdapter 
{
	CirclePanel panel_0 = new CirclePanel();
	
	ArrayList<Integer> a = new ArrayList<>();
	ArrayList<Integer> b = new ArrayList<>();
	Sector s = new Sector();
	public CircleClicked(CirclePanel panel_0) 
	{
		super();
		this.panel_0 = panel_0;
	}
	int i = 0;

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		panel_0.addCircle(new Circle(e.getX()-20, e.getY()-20, 40, Color.GREEN, i));

		a.add(e.getX()-20);
		b.add(e.getY()-20);
		s.Addcircle(a, b, i);
		i++;
		File click = new File("sound/Click.wav");
		MainWindow m = new MainWindow();
		if(m.addSound==true)
		{
			playSound(click);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
