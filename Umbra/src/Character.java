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

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682362805041451259L;

	Timer t = new Timer(30,this);



	// MapGenerator map =  new MapGenerator();
	int upper = 60;
	int lower = 30;
	int left = 430;
	int right = 500;
	int mapHeights [] = new int[3];
	int mapDistances [] = new int[3];
	Image platforms[] = new Image[3];

	Image[] enemy = new Image[7];
	int[] posEnemyX = new int[7];
	int[] posEnemyY = new int[7];
	int[] yDiff = new int[7];

	JLabel score = new JLabel();
	
int scoreNum = 0;



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


		for (int i = 0; i<enemy.length; i++) {
			enemy[i] = new ImageIcon("enemyUmbra.png").getImage();
			posEnemyX[i] = (int) (Math.random() * (1290)) +80 ;



		}




		for(int i = 0; i < platforms.length; i++){



			mapHeights[i] =  (int) (Math.random() * (upper - lower)) + lower;
			mapDistances[i] =  (int) (Math.random() * (right - left)) + left;


			platforms[i] = new ImageIcon("platformUmbra.png").getImage();



			System.out.println("Height"+ ":"+mapHeights[i]);





		}

		if(mapDistances[1] +  mapDistances[2] + mapDistances[0] >1290) {



		}


		//	System.out.println(position1);
		position2 = mapDistances[0];
		//	System.out.println(position2);
		position3 = position2 + mapDistances[1];
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
		g.drawImage(platforms[0],position1,500,mapDistances[0],535,null);
		g.drawImage(platforms[1],position2,460,mapDistances[1],535,null);
		g.drawImage(platforms[2],position3,530, mapDistances[2],535, null);


		for (int i = 0; i<enemy.length; i++) {



			g.drawImage(enemy[i],posEnemyX[i],posEnemyY[i],35,35,null);
		}
		add(score);
		
	}





	public void actionPerformed1(ActionEvent e)
	{
		//repaint();
		gravity();
	//	enemyKill();
		
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
			frameNumY-=70;
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
			frameNumY-=70;

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



		gravity();
		repaint();

	}

	public void gravity(){

		//first platform
		if((frameNumX > 0) &&(frameNumX < mapDistances[0]) ) { 
			if(frameNumY <= 500 ) {
				frameNumY += 20;
				repaint();
			}
		}

		if((frameNumX > 0) &&(frameNumX < mapDistances[0]) ) { 
			if(frameNumY >= 465 ) {
				frameNumY = 465;

				repaint();
			}
		}


		//second platform
		if((frameNumX >mapDistances[0]) &&(frameNumX < mapDistances[0] + mapDistances[1]) ) { 
			if(frameNumY <= 460) {
				frameNumY += 20;
				//illegalMove();

				repaint();
			}
		}

		if((frameNumX > mapDistances[0]) &&(frameNumX < mapDistances[0] + mapDistances[1]) )  { 
			if(frameNumY >= 425 ) {
				frameNumY  = 425 ;	
				repaint();
				//illegalMove();
			}
		}


		//Third Platform
		if((frameNumX >= position3) &&(frameNumX < mapDistances[0] + mapDistances[1]+ mapDistances[2]) ) { 
			if(frameNumY <= 530 ) {
				frameNumY += 20;
				repaint();
			}
		}
		if((frameNumX >= position3) &&(frameNumX < mapDistances[0] + mapDistances[1]+ mapDistances[2]) )  { 
			if(frameNumY >= 495 ) {
				frameNumY  = 495  ;	
				repaint();
			}
		}

		if(frameNumY <370) {
			frameNumY = 370;


		}
		illegalEnemy();
		
		enemyKill();
		
	}	


	public void illegalEnemy() {
		for(int i = 0; i<enemy.length;i++) {

			if((posEnemyX[i] >= mapDistances[0] ) && (posEnemyX[i] < position3 )) {
				posEnemyY[i] = 425;

			}
			if((posEnemyX[i] > 0 ) &&(posEnemyX[i] < mapDistances[0] )) {
				posEnemyY[i] = 465;

			}

			if((posEnemyX[i] >= position3 ) && (posEnemyX[i] < 1290 )) {
				posEnemyY[i] = 495;

			}



		}
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void newPosEnemy(int enemyInt) {


		posEnemyX[enemyInt] = (int) (Math.random() * (1290)) + 30 ;
	}

	public void enemyKill() {
		for (int i = 0; i<enemy.length;i++) {
			yDiff[i] = posEnemyY[i] - frameNumY-35;
			//System.out.println("started");
			if(((frameNumX >= posEnemyX[i] - 14) && (frameNumX <= posEnemyX[i] + 35+ 14))) {
				//System.out.println("Dead");
				
				
				if(( 14>= yDiff[i]) &&(yDiff[i] <= 35)) {
				
				System.out.println("EnemyKill");
				Graphics g = null;
				
				
	

				newPosEnemy(i);
				
				scoreNum++;
				
				String scoreString = "" + scoreNum;
				
				
				score.setText(scoreString);
				
				
				}
				
				
				if(frameNumY >= posEnemyY[i]) {
					
					System.out.println("Dead");
					Graphics g = null;
					
					
		
					
					//newPosEnemy(i);
					JOptionPane.showMessageDialog(null, "Game Over!");
					restart();
					//score.setText(scoreString);
					
					
					}
			}
			



			
			
		
			
			
			
		}
		
		
	}
	void restart(){
		for (int i = 0; i<enemy.length; i++) {
			enemy[i] = new ImageIcon("enemyUmbra.png").getImage();
			posEnemyX[i] = (int) (Math.random() * (1290)) +80 ;
		}
		frameNumX= 50;
		frameNumY = 460;
		repaint();
	}

}


