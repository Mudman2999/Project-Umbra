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
	public int frameNumX= 50;
	public int frameNumY = 50;


	int framePrev;

	Image img;
	Image plat;
	Graphics rect;
	private Timer gravityTimer;
	Graphics Character;

	public Character()
	{
		gravityTimer = new Timer(1000, this);
		gravityTimer.start();
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
		g.drawImage(img,frameNumX,frameNumY,this);


		g.drawImage(plat,0, 500, 1400, 870, null);
		//addKeyListener(this);

	}

	public void actionPerformed1(ActionEvent e)
	{
		repaint();
		gravity();
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Boundaries();
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNumX+=7;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNumX-=7;repaint();
		}
		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_UP){

			img = new ImageIcon("CHaracterUp.png").getImage();
			frameNumY-=30;

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
			frameNumX+=7;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_A){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNumX-=7;repaint();
		}
		
		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_W){

			img = new ImageIcon("CHaracterUp.png").getImage();
			frameNumY-=30;

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
		frameNumX = 0;


		t.start();



		System.out.println(t);


		addKeyListener(this);




	}


	public void actionPerformed(ActionEvent e)
	{
		//	System.out.println("x:" + x);


		
		gravity();
		repaint();

	}

	public void gravity(){
		if (frameNumY <= 461){
		frameNumY += 20;
		}
	}
	public void illegalMove() {
		System.out.println(frameNumY);
		if(frameNumY >= 462){

			frameNumY = 462;
			repaint();

		}else{

			frameNumY+=7;
			repaint();
		}
	}

	void Boundaries() {
		if(frameNumX <= 0){
			frameNumX = 0;
			repaint();

		}
		if(frameNumX >= 1240){
			frameNumX = 1240;
			repaint();

		}

	}



}


