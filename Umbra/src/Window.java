import javax.swing.JFrame;


public class Window extends JFrame{
	private Character panel;
	public Window()
	{
		setSize(1290,800);
		panel = new Character();
		add(panel);
		setVisible(true);
		panel.requestFocus(true);
		
		
		
	
	}
	
	
}
