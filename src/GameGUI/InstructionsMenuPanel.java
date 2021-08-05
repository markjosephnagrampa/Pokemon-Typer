package GameGUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InstructionsMenuPanel extends JPanel {
	//fields
		private Image img;
	
	public InstructionsMenuPanel(Image img){
		this.img=img;
	}
	public void setImage(Image img){
		this.img = img;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
}
