package WordThreading;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GameGUI.HealthBarPanel;

/**   The canvas that draws the words, health bars,
*     and the basic background
*/
public class WordCanvas extends JPanel {
	
	//Constructors
	public WordCanvas(){
		super();
	}
	public WordCanvas(int mode){ //0-easy 1-medium 2-hard 3-extreme
		new WordCanvas();
		switch(mode){
		case 0: foeLife=20; playerLife=3;
				img =  new ImageIcon(this.getClass().getResource("WordCanvas-Images/WordFrame-BG-electric.jpg"));
		break;
		case 1: foeLife=30; playerLife=4; 
				img =  new ImageIcon(this.getClass().getResource("WordCanvas-Images/WordFrame-BG-normal.jpg"));
		break;
		case 2: foeLife=40; playerLife=5; 
				img =  new ImageIcon(this.getClass().getResource("WordCanvas-Images/WordFrame-BG-water.jpg"));
		break;
		case 3: foeLife=50; playerLife=6; 
				img =  new ImageIcon(this.getClass().getResource("WordCanvas-Images/WordFrame-BG-psychic.jpg"));
		break;
		}
		//initialize health bars
		foeHealthBar = new HealthBarPanel(FOE_HEALTH_BarX,
				   FOE_HEALTH_BarY,HEALTH_BAR_WIDTH,HEALTH_BAR_HEIGHT,
				   foeLife,foeLife);
		playerHealthBar = new HealthBarPanel(PLAYER_HEALTH_BarX,
				   PLAYER_HEALTH_BarY,HEALTH_BAR_WIDTH,HEALTH_BAR_HEIGHT,
				   playerLife,playerLife);
	}
	/**
      Add a word to the canvas.
      @param w the word to add
   */
   public void add(Word w) {
      wordList.add(w);
   }
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
    //Background Element
      Image background = img.getImage();
      g2.drawImage(background, 0, 0, this);
    //Health Bar Elements 
      foeHealthBar.paintComponent(g);
      playerHealthBar.paintComponent(g);
      g.setColor(Color.BLACK);
     //Word Elements 
      for (int i = 0; i < wordList.size(); i++) {
         Word w = (Word)wordList.get(i);
         w.paint(g2);
      }
      
   }
   //getter and setter
   public HealthBarPanel getFoeHealthBar(){
	   return foeHealthBar;
   }
   public HealthBarPanel getPlayerHealthBar(){
	   return playerHealthBar;
   }
   //static fields 
   	//[health bar positions]
	   private static final int FOE_HEALTH_BarX=589;
	   private static final int FOE_HEALTH_BarY=87;
	   private static final int PLAYER_HEALTH_BarX=25;
	   private static final int PLAYER_HEALTH_BarY=557;
	   private static final int HEALTH_BAR_WIDTH=182;
	   private static final int HEALTH_BAR_HEIGHT=30;
	 //Image Background
	   private ImageIcon img;
   //fields
	   private int foeLife,playerLife; // starting lives of both pokemon
	   private ArrayList wordList=new ArrayList();
	   private HealthBarPanel foeHealthBar = new HealthBarPanel(FOE_HEALTH_BarX,
			   FOE_HEALTH_BarY,HEALTH_BAR_WIDTH,HEALTH_BAR_HEIGHT,20,20);//easy
	   private HealthBarPanel playerHealthBar = new HealthBarPanel(PLAYER_HEALTH_BarX,
			   PLAYER_HEALTH_BarY,HEALTH_BAR_WIDTH,HEALTH_BAR_HEIGHT,3,3);//easy
   
}


