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

import java.awt.*;



public class Enemy implements ActionListener  {
	Image[] enemy = new Image[7];
	int[] posEnemyX = new int[7];
	int[] posEnemyY = new int[7];
	int[] yDiff = new int[7];
	
	int distance = 0;
	
	

	public Enemy() {

		for (int i = 0; i<enemy.length;i++) {
			enemy[i] = new ImageIcon("enemyUmbra.png").getImage();

		}


		
		

		
	}






	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	///	movement();

	}






	public void illegalEnemy(int plat1, int plat2) {
		for(int i = 0; i<enemy.length;i++) {

			if((posEnemyX[i] >=  plat1) && (posEnemyX[i] < plat2 )) {
				posEnemyY[i] = 425;
				

			}
			if((posEnemyX[i] > 0 ) &&(posEnemyX[i] < plat1 )) {
				posEnemyY[i] = 465;

			}

			if((posEnemyX[i] >= plat2 ) && (posEnemyX[i] < 1290 )) {
				posEnemyY[i] = 495;

			}



		}
	}
	
	
	
	public void newPosEnemy(int enemyInt) {


		posEnemyX[enemyInt] = (int) (Math.random() * (1290)) + 30 ;
	}
	
	
	
	
	
	
	void restart(){
		for (int i = 0; i<enemy.length; i++) {
			enemy[i] = new ImageIcon("enemyUmbra.png").getImage();
			posEnemyX[i] = (int) (Math.random() * (1290)) +80 ;
		}
	//	charact.frameNumX= 50;
		//charact.frameNumY = 460;
		//charact.scoreNum = -1;

	//	character.repaint();
	}
}







