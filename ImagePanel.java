// Brayden Hopkins
// 10/21/2020

package project2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImagePanel extends JPanel{
	private int height;
	private int width;
	
	private ImageIcon image;
	private int x,y;
	
	public ImagePanel(int w, int h)
	{
		width = w;
		height = h;
		
		image = new ImageIcon(this.getClass().getResource("/project2/syringe.jpg"));
		
		setPreferredSize(new Dimension(w,h));
		setBackground(Color.WHITE);
	}
	
	public void changeImage(String filename)
	{
		image = new ImageIcon(filename);
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		image.paintIcon(this, page, x, y);
		repaint();
	}

}
