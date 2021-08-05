package GameGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class HealthBarPanel extends JPanel {
	private int healthBarX;
	private int healthBarY;
	private int healthBarWidth;
	private int healthBarHeight;
	private int health;
	private int maxHealth;
	private int healthChangeWidth;
	//constructor
	public HealthBarPanel(int healthBarX, int healthBarY, int healthBarWidth,
			int healthBarHeight, int health, int maxHealth){
		this.healthBarX=healthBarX;
		this.healthBarY=healthBarY;
		this.healthBarWidth=healthBarWidth;
		this.healthBarHeight=healthBarHeight;
		this.health=health;
		this.maxHealth=maxHealth;
		this.healthChangeWidth = healthBarWidth/maxHealth;
	}
	//internal methods
	//Method for Unloading Health Bar
	public void damage(){
		if(health!=0){
			health--;
			healthBarWidth=healthChangeWidth*health;
		}
	}
	//Flag method to check if the game is done [Zero Life]
	public boolean isEmpty(){
		if(this.health==0){return true;}
		else{return false;}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
	    g.fillRect(healthBarX, healthBarY, healthBarWidth, healthBarHeight);
	    g.setColor(Color.WHITE);
	    g.setFont(new Font("ARIAL", Font.BOLD, 15));
	    g.drawString(Integer.toString(health)+"/"+Integer.toString(maxHealth), healthBarX+70, healthBarY+15);
	}
	//getter and setter
	public int getHealthBarX() {
		return healthBarX;
	}
	public void setHealthBarX(int healthBarX) {
		this.healthBarX = healthBarX;
	}
	public int getHealthBarWidth() {
		return healthBarWidth;
	}
	public void setHealthBarWidth(int healthBarWidth) {
		this.healthBarWidth = healthBarWidth;
	}
	public int getHealthBarY() {
		return healthBarY;
	}
	public void setHealthBarY(int healthBarY) {
		this.healthBarY = healthBarY;
	}
	public int getHealthBarHeight() {
		return healthBarHeight;
	}
	public void setHealthBarHeight(int healthBarHeight) {
		this.healthBarHeight = healthBarHeight;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	

}
