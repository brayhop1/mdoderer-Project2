// Brayden Hopkins
// 10/21/2020

package project2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import project2.MainPanel;

public class MainFrame extends JPanel{

	public static void main(String[] args) {
		JFrame frame = new JFrame("Covid Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(830, 550);
		
		MainPanel myPanel = new MainPanel();
		frame.getContentPane().add(myPanel);
		
		frame.setVisible(true);

	}

}
