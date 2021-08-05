package GameGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import WordThreading.WordFrame;

public class StoryGUI extends JPanel implements KeyListener {
	private Image storyf, story1, story2, story3, story4, story5;
	private JTextField tKey1;
	public int spaceCtr = 0;
	private StoryDriver c; // where this JPanel will be placed
	//Constructor
	public StoryGUI(StoryDriver c){
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/storyf.png"));
        storyf = img1.getImage();
        ImageIcon img2 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/story1.png"));
        story1 = img2.getImage();
        ImageIcon img3 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/story2.png"));
        story2 = img3.getImage();
        ImageIcon img4 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/story3.png"));
        story3 = img4.getImage();
        ImageIcon img5 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/story4.png"));
        story4 = img5.getImage();
        ImageIcon img6 = new ImageIcon(this.getClass().getResource("StoryGUI-Images/story5.png"));
        story5 = img6.getImage();
        
        tKey1 = new JTextField("STORY");
        tKey1.setFont(new Font("sansserif", Font.PLAIN, 55));
        tKey1.addKeyListener(this);
		tKey1.setEditable(false);
		tKey1.setBackground(Color.red);
		add(tKey1);
		this.c=c;
		
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == 32) {
			tKey1.setBackground(Color.GREEN);
			tKey1.setText("STORY");
			spaceCtr++;
			c.setSpaceCtr(spaceCtr);
			switch(spaceCtr){
				case 1: storyf = story1; break;
				case 2: storyf = story2; break;
				case 3: storyf = story3; break;
				case 4: storyf = story4; break;
				case 5: storyf = story5; break;
				case 6: c.loadNext(); break;
			}
		}
		repaint();
	}			
	
	@Override
	public void keyReleased(KeyEvent e){}
	@Override
	public void keyTyped(KeyEvent e){}
		
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(storyf, 0, 0, this);
	}
	

}