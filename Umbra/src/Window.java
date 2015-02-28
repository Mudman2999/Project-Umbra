import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;


public class Window extends JFrame{
	private Character panel;
	//private Enemy enemy;

	public Window(String input)
	{
		setSize(1290,800);
		panel = new Character();
		add(panel);
		setVisible(true);
		panel.requestFocus(true);
		setTitle(input);



	}


}
