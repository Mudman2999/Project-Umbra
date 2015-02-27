import java.awt.Color;
import java.awt.Component;
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

public class MapGenerator extends Component {
	
	int upper = 60;
	int lower = 30;
	int left = 430;
	int right = 500;
	int mapHeights [] = new int[3];
	int mapDistances [] = new int[3];
	Image platforms[] = new Image[3];


	MapGenerator(){
		for(int i = 0; i < platforms.length; i++){



			mapHeights[i] =  (int) (Math.random() * (upper - lower)) + lower;
			mapDistances[i] =  (int) (Math.random() * (right - left)) + left;


			platforms[i] = new ImageIcon("platformUmbra.png").getImage();



			System.out.println("Height"+ ":"+mapHeights[i]);





		}



	}

	public void paint(Graphics g)
	{


		for (int i = 0; i<platforms.length;i++) {

			g.drawImage(platforms[i],0,0,mapHeights[i],mapDistances[i],null);
		}


		//addKeyListener(this);

	}


}	
