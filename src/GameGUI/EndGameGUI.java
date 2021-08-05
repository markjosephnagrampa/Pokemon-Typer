package GameGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndGameGUI extends JFrame {
	//fields
	private ImageIcon badge,bgImage;
	private JButton mainMenu,exit,selectDifficulty;
	private JPanel contentPane;
	private JLabel background;
	
	public EndGameGUI(int mode, int winStatus){
		//Frame Properties
			setSize(386,390);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setLocationRelativeTo(null);
		//Different Layouts for win and lose situation
		if(winStatus==0){ // lost
			setTitle("Defeat");
			bgImage = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/defeat.jpg"));
			background = new JLabel(bgImage);
		}
		else{ // won
			setTitle("Victory");
			bgImage = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory copy.jpg"));
			switch(mode){
				case 0: badge = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/sunbadge.png")); break;
				case 1: badge = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/fistbadge.png")); break;
				case 2: badge = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/waterbadge.png")); break;
				case 3: badge = new ImageIcon(this.getClass().getResource("EndGameGUI-Images/masterbadge.png")); break;
			}
			//Adding Image
				JLabel badgeImg = new JLabel(badge);
				badgeImg.setBounds(200,100,140,116);
				background = new JLabel(bgImage);
				background.add(badgeImg);
		}
		//Border to Make BG Label Encompass Entire Window
			contentPane = new JPanel();
			contentPane.setBackground(Color.GRAY);
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout());
			background.setBounds(0, 0, 386, 375);
			background.setLayout(null);
		//Adding buttons
			mainMenu = new JButton();
			mainMenu.setBounds(162, 257, 105, 42);
			mainMenu.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-mainmenu.jpg")));
			mainMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					mainMenu.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-mainmenu2.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					MenuGUI menu = new MenuGUI();
					close();
				}
				public void mouseExited(MouseEvent e) {
					mainMenu.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-mainmenu.jpg")));
				}
			});
			background.add(mainMenu);
			
			exit = new JButton();
			exit.setBounds(219, 311, 105, 42);
			exit.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-exit.jpg")));
			exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					exit.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-exit2.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
				public void mouseExited(MouseEvent e) {
					exit.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-exit.jpg")));
				}
			});
			background.add(exit);
			
			selectDifficulty = new JButton();
			selectDifficulty.setBounds(272, 257, 105, 42);
			selectDifficulty.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-selectdifficulty.jpg")));
			selectDifficulty.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					selectDifficulty.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-selectdifficulty2.jpg")));
				}
				public void mouseClicked(MouseEvent e) {
					new DifficultyGUI();
					close();
				}
				public void mouseExited(MouseEvent e) {
					selectDifficulty.setIcon(new ImageIcon(this.getClass().getResource("EndGameGUI-Images/victory-selectdifficulty.jpg")));
				}
				
			});
			background.add(selectDifficulty);
			contentPane.add(background);
			//Visibility
			this.setVisible(true);
	}
	//from external source: Closing Event
		public void close(){
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		}
}
