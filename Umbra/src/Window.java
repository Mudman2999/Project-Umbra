import javax.swing.JFrame;


public class Window extends JFrame{
	private Character panel;
	private MapGenerator map;
	
	public Window()
	{
		setSize(1290,800);
		panel = new Character();
		map = new MapGenerator();
		
		add(panel);
		//add(map);
	
		
		setVisible(true);
		panel.requestFocus(true);
		
		
		
	
	}
	
	
}
