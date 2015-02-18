import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Main extends JPanel implements ActionListener, KeyListener {

	private Timer t;
	//change/add instance variables as needed
	int x;
	int y;
	int frameNum= 50;
	int frameNum2 = 50;
	Image img;

	public Main()
	{
		img = new ImageIcon("CharacterRight.png").getImage();
		addKeyListener(this);
	}

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		//	g.drawOval(x,y,50,50);
		g.drawImage(img,frameNum,frameNum2,this);
		
		
		g.drawRect(0, 300, 900, 90000);
		//addKeyListener(this);
	
	}

	//Modify this method as needed.
	/*public void actionPerformed(ActionEvent e)
	{
		System.out.println("x:" + x);
		frameNum++;
		repaint();
	}*/
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNum+=3;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			
			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNum-=3;repaint();
		}
		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_UP){
			
			img = new ImageIcon("CHaracterUp.png").getImage();
			frameNum2-=30;

			repaint();
			////delay this by x amount of time
			//frameNum2 += 30;


		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			frameNum2+=3;
			repaint();
		}

	}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {



	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}


