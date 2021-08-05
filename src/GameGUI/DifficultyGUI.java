package GameGUI;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class DifficultyGUI extends JFrame {
	
	private JButton noob, amateur, expert, master, back;
	JLabel description = new JLabel();
	JLabel menu = new JLabel(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALSCREEN.png")));
	
	public DifficultyGUI(){
		
		setTitle("Difficulty Menu");
		setSize(800,630);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Mainframe creation
		JPanel mainFrame = new JPanel();
		mainFrame.setBackground(Color.GRAY);
		setContentPane(mainFrame);
		mainFrame.setLayout(new BorderLayout());
		menu.setBounds(0, 0, 800, 600);
		mainFrame.add(menu);
		
		//Description initialize
		description.setBounds(431, 214, 181, 226);
		description.setBackground(Color.RED);
		description.setVisible(true);
		menu.add(description);
		
		//Diff. buttons
		back = new JButton();
		back.setBounds(160, 128, 51, 51);
		back.setBorderPainted(false);
		back.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/BACK2.png")));
		back.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				back.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/BACK.png")));
			}
			public void mouseClicked(MouseEvent e){
				close();
				MenuGUI menuGui = new MenuGUI();
			}
			public void mouseExited(MouseEvent e){	
				back.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/BACK2.png")));
			}
		});
		menu.add(back);
		
		noob = new JButton();
		noob.setBounds(170, 241, 200, 24);
		noob.setBorderPainted(false);
		noob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				noob.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/HIGHNOOB.png")));
				description.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NOOBIEDESCRIPTION.png")));
			}
			public void mouseClicked(MouseEvent e) {
				close();
				WordFrameGUI WordFrameGUI = new WordFrameGUI(0);
			}
			public void mouseExited(MouseEvent e) {
				noob.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALNOOB.png")));
				description.setIcon(null);
			}
		});
		noob.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALNOOB.png")));
		menu.add(noob);
		
		amateur = new JButton();
		amateur.setBounds(170, 281, 200, 24);
		amateur.setBorderPainted(false);
		amateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				amateur.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/HIGHAMATEUR.png")));
				description.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/AMATEURDESCRIPTION.png")));
			}
			public void mouseClicked(MouseEvent e) {
				close();
				WordFrameGUI WordFrameGUI = new WordFrameGUI(1);
			}
			public void mouseExited(MouseEvent e) {
				amateur.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALAMATEUR.png")));
				description.setIcon(null);
			}
		});
		
		amateur.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALAMATEUR.png")));
		menu.add(amateur);
		
		expert = new JButton();
		expert.setBounds(170, 321, 200, 24);
		expert.setBorderPainted(false);
		expert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				expert.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/HIGHEXPERT.png")));
				description.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/EXPERTDESCRIPTION.png")));
			}
			public void mouseClicked(MouseEvent e) {
				close();
				WordFrameGUI WordFrameGUI = new WordFrameGUI(2);
			}
			public void mouseExited(MouseEvent e) {
				expert.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALEXPERT.png")));
				description.setIcon(null);
			}
		});
		expert.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALEXPERT.png")));
		menu.add(expert);
		
		master = new JButton();
		master.setBounds(170, 358, 200, 24);
		master.setBorderPainted(false);
		master.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				master.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/HIGHMASTER.png")));
				description.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/MASTERDESCRIPTION.png")));
			}
			public void mouseClicked(MouseEvent e) {
				close();
				WordFrameGUI WordFrameGUI = new WordFrameGUI(3);
			}
			public void mouseExited(MouseEvent e) {
				master.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALMASTER.png")));
				description.setIcon(null);
			}
		});
		master.setIcon(new ImageIcon(this.getClass().getResource("DifficultyGUI-Images/NEUTRALMASTER.png")));
		menu.add(master);
		
		
		setVisible(true);
	}
	
	public void close(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
}