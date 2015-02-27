import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Character  extends JPanel implements ActionListener, KeyListener {

	boolean isOnGround = true;
	/**
	 * 
	 */
	private static final long serialVersionUID = 2682362805041451259L;

	Timer t = new Timer(30,this);
	private Enemy classEnemy = new Enemy();
	MapGenerator map = new MapGenerator();
	
	



	// MapGenerator map =  new MapGenerator();
	int upper = 60;
	int lower = 30;
	int left = 430;
	int right = 500;
	

	


	int scoreNum = -1;



	int position1;
	int position2;
	int position3;



	//change/add instance variables as needed
	int x;
	int y;
	public int frameNumX= 50;
	public int frameNumY = 460;


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

		for (int i = 0; i<classEnemy.enemy.length; i++) {
			classEnemy.enemy[i] = new ImageIcon("enemyUmbra.png").getImage();
			classEnemy.posEnemyX[i] = (int) (Math.random() * (1290)) +80 ;



		}




		for(int i = 0; i < map.platforms.length; i++){






			map.platforms[i] = new ImageIcon("platformUmbra.png").getImage();



			System.out.println("Height"+ ":"+map.mapHeights[i]);





		}

		


		//	System.out.println(position1);
		position2 = map.mapDistances[0];
		//	System.out.println(position2);
		position3 = position2 + map.mapDistances[1];
		//		System.out.println(position3);







	}                           

	//Overrides the paint method to draw whatever you want.
	public void paint(Graphics g)
	{



		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		g.drawImage(BG,0,0,1290,800,this);
		g.drawImage(img,frameNumX,frameNumY,this);
		g.drawImage(plat,0, 500, 1400, 870, null);


		//platforms 
		g.drawImage(map.platforms[0],position1,500,map.mapDistances[0],535,null);
		g.drawImage(map.platforms[1],position2,460,map.mapDistances[1],535,null);
		g.drawImage(map.platforms[2],position3,530, map.mapDistances[2],535, null);


		for (int i = 0; i<classEnemy.enemy.length; i++) {



			g.drawImage(classEnemy.enemy[i],classEnemy.posEnemyX[i],classEnemy.posEnemyY[i],35,35,null);
		}


	}






	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			Boundaries();
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNumX+=14;
			illegalMove();

			repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNumX-=14;repaint();
			illegalMove();
		}
		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_UP){

			img = new ImageIcon("CHaracterUp.png").getImage();
			if (isOnGround){
			frameNumY-=100;
			isOnGround = false;
			}
			gravity();
			repaint();

			//	illegalMove();
			////delay this by x amount of time
			//frameNum2 += 30;


		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			gravity();

			System.out.println("X"+frameNumX);
			System.out.println("Y"+frameNumY);



		}



		if(e.getKeyCode() == KeyEvent.VK_D){
			Boundaries();
			img = new ImageIcon("CharacterRight.png").getImage();
			frameNumX+=14;repaint();
		}
		//	x += 10;
		if(e.getKeyCode() == KeyEvent.VK_A){
			Boundaries();

			img = new ImageIcon("CharacterLeft.png").getImage();
			frameNumX-=14;repaint();
		}

		//x -= 10;
		if(e.getKeyCode() == KeyEvent.VK_W){

			img = new ImageIcon("CHaracterUp.png").getImage();
			if (isOnGround){
			frameNumY-=100;
			isOnGround = false;
			}

			repaint();
			////delay this by x amount of time
			//frameNum2 += 30;


		}

		if(e.getKeyCode() == KeyEvent.VK_S	){
			illegalMove();

			gravity();


		}


		if(e.getKeyCode() == KeyEvent.VK_SPACE) {			
			img = new ImageIcon("CHaracterUp.png").getImage();
			frameNumY-=70;
			gravity();
			repaint();
		}

	}
	public void actionPerformed(ActionEvent e)
	{
		//	System.out.println("x:" + x);
		if((frameNumX > 0) &&(frameNumX < map.mapDistances[0]) ) { 
			if(frameNumY <= 500 ) {
				isOnGround = true;
				repaint();
			}
		}

		
		


		//second platform
		if((frameNumX >map.mapDistances[0]) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]) ) { 
			if(frameNumY <= 460) {
				isOnGround = true;

				repaint();
			}
		}


		//Third Platform
		if((frameNumX >= position3) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]+ map.mapDistances[2]) ) { 
			if(frameNumY <= 530 ) {
				isOnGround = true;
				repaint();
			}
		}
		


		gravity();
		repaint();



	}

	public void gravity(){

		//first platform
		if((frameNumX > 0) &&(frameNumX < map.mapDistances[0]) ) { 
			if(frameNumY <= 500 ) {
				frameNumY += 20;
				repaint();
			}
		}

		if((frameNumX > 0) &&(frameNumX < map.mapDistances[0]) ) { 
			if(frameNumY >= 465 ) {
				frameNumY = 465;

				repaint();
			}
		}


		//second platform
		if((frameNumX >map.mapDistances[0]) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]) ) { 
			if(frameNumY <= 460) {
				frameNumY += 20;
				//illegalMove();

				repaint();
			}
		}

		if((frameNumX > map.mapDistances[0]) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]) )  { 
			if(frameNumY >= 425 ) {
				frameNumY  = 425 ;	
				repaint();
				//illegalMove();
			}
		}


		//Third Platform
		if((frameNumX >= position3) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]+ map.mapDistances[2]) ) { 
			if(frameNumY <= 530 ) {
				frameNumY += 20;
				repaint();
			}
		}
		if((frameNumX >= position3) &&(frameNumX < map.mapDistances[0] + map.mapDistances[1]+ map.mapDistances[2]) )  { 
			if(frameNumY >= 495 ) {
				frameNumY  = 495  ;	
				repaint();
			}
		}

		if(frameNumY <370) {
			frameNumY = 370;


		}
		classEnemy.illegalEnemy(map.mapDistances[0], position3);

		enemyKill();

	}	



	public void illegalMove() {

		if((frameNumY <= 800)  && (frameNumY >= 400)) {
			System.out.println("True");

			gravity();
			if((frameNumX>= position2-35) && (frameNumX <= position2 -7))  {

				System.out.println(frameNumX);

				frameNumX = position2 - 35;


				gravity();

			}
		}




		if((frameNumY <= 800)  && (frameNumY >= 460)) {
			System.out.println("True");

			gravity();
			if((frameNumX>= position3-35) && (frameNumX <= position3 -7))  {

				System.out.println(frameNumX);

				frameNumX = position3 - 35;


				gravity();

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


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	

	public void enemyKill() {
		for (int i = 0; i<classEnemy.enemy.length;i++) {
			classEnemy.yDiff[i] = classEnemy.posEnemyY[i] - frameNumY-35;
			//System.out.println("started");
			if(((frameNumX >= classEnemy.posEnemyX[i] - 14) && (frameNumX <= classEnemy.posEnemyX[i] + 35))) {
				//System.out.println("Dead");


				if(( 14>= classEnemy.yDiff[i]) &&(classEnemy.yDiff[i] <= 35)) {

					System.out.println("EnemyKill");
					Graphics g = null;




					classEnemy.newPosEnemy(i);

					scoreNum++;

					String scoreString = "" + scoreNum;


				


				}


				if(frameNumY >= classEnemy.posEnemyY[i]) {

					System.out.println("Dead");
					Graphics g = null;



					//newPosEnemy(i);
					JOptionPane.showMessageDialog(null, "Game Over! You killed "+  scoreNum + " enemies!");
					classEnemy.restart();
					
					
					//score.setText(scoreString);

					frameNumX= 50;
					frameNumY = 460;
					scoreNum = -1;
				}
			}
		}
	}
	
}