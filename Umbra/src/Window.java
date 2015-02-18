import javax.swing.JFrame;
public class Window extends JFrame{
	private Main panel;
	public Window()
	{
		setSize(400,300);
		panel = new Main();
		add(panel);
		setVisible(true);
		panel.requestFocus(true);
		
		
		
	
	}
	
	
}
