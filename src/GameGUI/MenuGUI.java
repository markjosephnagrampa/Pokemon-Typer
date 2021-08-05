package GameGUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

import WordThreading.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Random;


public class MenuGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnExit,btnInstructions,btnStory,btnStartGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		MenuGUI frame = new MenuGUI();
		frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	public MenuGUI() {
		//Frame Properties
			setTitle("Pokemon Menu");
			setSize(800,630);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLocationRelativeTo(null);
		//Border to Make BG Label Encompass Entire Window
			contentPane = new JPanel();
			contentPane.setBackground(Color.GRAY);
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout());
			JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("MenuGUI-Images/Menu-GUI3.jpg")));
			background.setBounds(0, 0, 800, 600);
			background.setLayout(null);
			contentPane.add(background);
		//Adding Other Buttons
			//Start Button
			btnStartGame = new JButton();
			btnStartGame.setBounds(476, 162, 290, 92);
			btnStartGame.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnStartGame.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Start2.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					close();
					DifficultyGUI difficulty = new DifficultyGUI();
				}
				public void mouseExited(MouseEvent e) {
					btnStartGame.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Start4.jpg")));
				}
			});
			btnStartGame.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Start4.jpg")));
			background.add(btnStartGame);
			
			//Story Button
			btnStory = new JButton();
			btnStory.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnStory.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Story2.jpg")));
				}
				public void mouseExited(MouseEvent e) {
					btnStory.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Story.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					close();
					new StoryDriver();
				}
			});
			btnStory.setBounds(476, 357, 286, 74);
			btnStory.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Story.jpg")));
			background.add(btnStory);
			
			//Instructions Button
			btnInstructions = new JButton();
			btnInstructions.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnInstructions.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Instructions2.jpg")));
				}
				public void mouseExited(MouseEvent e) {
					btnInstructions.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Instructions.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					close();
					new InstructionsMenuGUI();
				}
			});
			btnInstructions.setBounds(475, 262, 287, 83);
			btnInstructions.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Instructions.jpg")));
			background.add(btnInstructions);
			
			//Exit Button
			btnExit = new JButton();
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnExit.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Exit2.jpg")));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					btnExit.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Exit.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			btnExit.setBounds(479, 444, 284, 80);
			btnExit.setIcon(new ImageIcon(this.getClass().getResource("MenuGUI-Images/btn-Exit.jpg")));
			background.add(btnExit);
		//Visibility
		setVisible(true);
	}
	//from external source: Closing Event
	public void close(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
}
