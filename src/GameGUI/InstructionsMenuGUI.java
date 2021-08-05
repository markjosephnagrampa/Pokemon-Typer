package GameGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class InstructionsMenuGUI extends JFrame implements ActionListener {
	
	//fields
	private Image img;
	private ImageIcon imgIcon;
	private InstructionsMenuPanel instructionPanel;
	private JButton home;
	private int ctr=0;
	
	//constructors
	public InstructionsMenuGUI(){
		//Frame Properties
			setTitle("Instructions");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(800, 650);
			setLocationRelativeTo(null);
			setResizable(false);
			imgIcon= new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/frame1.jpg"));
			img = imgIcon.getImage();
		//Adding JPanel Component
			instructionPanel = new InstructionsMenuPanel(img);
			instructionPanel.setLayout(null);
			add(instructionPanel);
		//timer [refresh screen every 500 ms]
			Timer changeFrame = new Timer(500,this);
			changeFrame.start();
			setVisible(true);
		//Home button
			home = new JButton();
			home.setBackground(Color.GRAY);
			home.setIcon(new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/BACK2INST.png")));
			home.setBounds(15, 15, 60, 60);
			home.setBorderPainted(false);
			home.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseEntered(MouseEvent e){
					home.setIcon(new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/BACKINST.png")));
				}
				public void mouseClicked(MouseEvent e){
					close();
					MenuGUI menuGui = new MenuGUI();
				}
				public void mouseExited(MouseEvent e){	
					home.setIcon(new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/BACK2INST.png")));
				}
			});
			instructionPanel.add(home);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ctr++;
		if(ctr>3){ctr=0;}
		switch(ctr){
		case 0: imgIcon= new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/frame1.jpg")); break;
		case 1: imgIcon= new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/frame2.jpg")); break;
		case 2: imgIcon= new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/frame3.jpg")); break;
		case 3: imgIcon= new ImageIcon(this.getClass().getResource("InstructionsMenuGUI-Images/frame4.jpg")); break;
		}
		img = imgIcon.getImage();
		instructionPanel.setImage(img);
		repaint();
		
	}

	public void close(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
}
