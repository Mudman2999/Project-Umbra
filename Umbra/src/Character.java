import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Character  extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682362805041451259L;

	Timer t = new Timer(30,this);



	// MapGenerator map =  new MapGenerator();
	int upper = 60;
	int lower = 30;
	int left = 15;
	int right = 1290;
	int mapHeights [] = new int[3];
	int mapDistances [] = new int[3];
	Image platforms[] = new Image[3];


	int position1;
	int position2;
	int position3;



	//change/add instance variables as needed
	int x;
	int y;
	public int frameNumX= 50;
	public int frameNumY = 500;


	int framePrev;

	Image img;
	Image plat;


	Image BG;


	Graphics rect;
	private Timer gravityTimer;
	Graphics Character;

	public Character()
	{
		gravityTimer = new Timer(1000, this);
		gravityTimer.start();
		img = new ImageIcon("CharacterRight.png").getImage();


		BG = new ImageIcon("BGUmbra.png").getImage();
		addKeyListener(this);
		//add(map);
		//	map.setVisible(true);





		for(int i = 0; i < platforms.length; i++){



			mapHeights[i] =  (int) (Math.random() * (upper - lower)) + lower;
			mapDistances[i] =  (int) (Math.random() * (right - left)) + left;


			platforms[i] = new ImageIcon("platformUmbra.png").getImage();



			System.out.println(mapHeights[i]);
			System.out.println(mapDistances[i]);





		}

		if(mapDistances[1] +  mapDistances[2] + mapDistances[0] >1290) {



		}

		position1 = 0;
		//	System.out.println(position1);
		position2 = mapDistances[1];
		//	System.out.println(position2);
		position3 = mapDistances[1]+ mapDistances[2];
		//		System.out.println(position3);







	}                           

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{



		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		//	g.drawOval(x,y,50,50);

		g.drawImage(BG,0,0,1290,800,this);
		g.drawImage(img,frameNumX,frameNumY,this);


		g.drawImage(plat,0, 500, 1400, 870, null);




		g.drawImage(platforms[0],position1,500,mapDistances[1],500+mapHeights[0],null);



		//g.drawImage(platforms[2],position2,200,mapDistances[2],mapHeights[2],null);
		g.drawImage(platforms[1],position2,500-mapHeights[1],mapDistances[2],500+ mapHeights[1],null);
		g.drawImage(platforms[2], position3, 500+mapHeights[2], mapDistances[0], 500+ mapHeights[2], null);




		//addKeyListener(this);




	}





	public void actionPerformed1(ActionEvent e)
	{
		//repaint();
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
			illegalMove();

		}
	}
	public void illegalMove() {
		//System.out.println(frameNumY);


		if(frameNumX <= position2) {
			if(frameNumY >= 475){

				frameNumY = 475;
				repaint();

			}
		}


		else if (frameNumX > position2 && frameNumX < position3){
			if(frameNumY >= 500- mapHeights[1]){

				frameNumY = 500- mapHeights[1] ;
				repaint();

			}
		}
		else if(frameNumX >= position3){
			if(frameNumY >= 500 + mapHeights[2]){
				frameNumY = 500 + mapHeights[2];

			}

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


