package WordThreading;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JPanel;


public class Word extends JPanel {
	private static final int LEFT_BOUND=100, UPPER_BOUND=150;
	private int x = 700; // Original position
	private int y;
	private String string; // the string inside the word object
	private Component c; // the component where the word object is placed
	private boolean forDisposal=false; // flag for word removal
	//constructor
		public Word(Component c, String string){
			this.string=string;
			this.c=c;
			Random random = new Random();
			x=700;
			y=UPPER_BOUND+random.nextInt(400);
		}
		public Word(String string){
			this.string=string;
			Random random = new Random();
			x=700;
			y=100+random.nextInt(400);
		}
		
	//implemented methods
	    
	    public void paint(Graphics g){
	    	if(forDisposal==true){}
	    	else{
		    	Graphics2D g2d = (Graphics2D)g;
		    	String st = string;
		    	Font font = new Font("Arial", Font.BOLD, 20);
		    	FontRenderContext fontRendContext = g2d.getFontRenderContext();
		    	GlyphVector glyphVector = font.createGlyphVector(fontRendContext, st);
		    	g2d.drawGlyphVector(glyphVector, x, y);
	    	}
	    }
	    
	    public void move() {
			x--;
			if(x==LEFT_BOUND){forDisposal=true;}
			c.repaint();
		}
	//getter and setter
		public String getString() {
			return string;
		}
		public void setString(String string) {
			this.string = string;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setforDisposal(boolean forDisposal){
			this.forDisposal=forDisposal;
		}
		public boolean getforDisposal() {
			return forDisposal;
		}
		

}
