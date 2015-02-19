import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;






import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Character  extends JPanel implements ActionListener, KeyListener {

	Timer t = new Timer(30,this);
	//change/add instance variables as needed
	int x;
	int y;
	int frameNum= 50;
	int frameNum2 = 50;


	int framePrev;

	Image img;
	Image plat;
	Graphics rect;

	Graphics Character;

	public Character()
	{
		img = new ImageIcon("CharacterRight.png").getImage();
		plat = new ImageIcon("testPlatform.png").getImage();
		addKeyListener(this);
	}

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{



		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		//	g.drawOval(x,y,50,50);
		g.drawImage(img,frameNum,frameNum2,this);


		g.drawImage(plat,0, 500, 1400, 870, null);
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
			Boundaries();
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNum+=7;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNum-=7;repaint();
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
			illegalMove();

		}



		if(e.getKeyCode() == KeyEvent.VK_D){
			Boundaries();
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNum+=7;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_A){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNum-=7;repaint();
		}
		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_W){

			img = new ImageIcon("CHaracterUp.png").getImage();
			frameNum2-=30;

			repaint();
			////delay this by x amount of time
			//frameNum2 += 30;


		}

		if(e.getKeyCode() == KeyEvent.VK_S	){
			illegalMove();

		}


		if(e.getKeyCode() == KeyEvent.VK_SPACE) {			

		}

	}
	public void keyReleased(KeyEvent e) {
		//frameNum2 = 460;	
	}
	public void keyTyped(KeyEvent e) {



	}
	public void up()
	{
		img = new ImageIcon("CharacterUp.png").getImage();
		frameNum = 0;


		t.start();



		System.out.println(t);


		addKeyListener(this);




	}


	public void actionPerformed(ActionEvent e)
	{
		//	System.out.println("x:" + x);


		frameNum2-= 5;







		repaint();

	}

	public void illegalMove() {
		System.out.println(frameNum2);
		if(frameNum2 >= 462){

			frameNum2 = 462;
			repaint();

		}else{

			frameNum2+=7;
			repaint();
		}
	}

	void Boundaries() {
		if(frameNum <= 0){
			frameNum = 0;
			repaint();

		}
		if(frameNum >= 1240){
			frameNum = 1240;
			repaint();

		}

	}



}


