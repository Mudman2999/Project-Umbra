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
	int i = 10;
	Timer t = new Timer(30,this);


	int randomPositions[] = new int[i];
	Image enemies[] = new Image[i];

	//Image enemy[] = new Image[1];


	int upper = 60;
	int lower = 30;
	int left = 430;
	int right = 700;




	public Enemy() {

		for (int i = 0; i<enemies.length;i++) {
			enemies[i] = new ImageIcon("UmbraCoin.png").getImage();

		}


		for (int i = 0; i<randomPositions.length; i++) {
			randomPositions[i] = (int) (Math.random() * (right - left)) + left;
			System.out.println(randomPositions[i]);
		}
	}


	void paint(Graphics g) {
		for (int i = 0; i<enemies.length; i++) {
			g.drawImage(enemies[i], randomPositions[i],12, 35, 35, null);


		}
	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		movement();

	}

	public void movement(){

	}





}






