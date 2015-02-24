import javax.swing.JFrame;


public class Window extends JFrame{
	private Character panel;
	private Enemy enemy;

	public Window()
	{
		setSize(1290,800);
		panel = new Character();
		//senemy = new Enemy();

		add(panel);


		//add(map);




		setVisible(true);
		panel.requestFocus(true);




	}


}
