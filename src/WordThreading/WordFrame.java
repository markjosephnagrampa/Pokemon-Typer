package WordThreading;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GameGUI.*;

/**
   The frame with canvas and buttons.
 */
public class WordFrame extends JFrame implements ActionListener {
	
	//Fields
	
	private WordCanvas canvas;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 630;
	//edited
	private int mode; //20-easy 35-medium 55-hard 85-extreme
	private String typedWord="";
	private Container contentPane;
	private JTextField text;
	private ArrayList<String> sArray = new ArrayList();
	private ArrayList<WordThread> wThread = new ArrayList();
	private Timer t1,t2;
	/**
      Constructs the frame with the canvas for showing the
      moving words and Start and Close buttons
	 */
	
	//Constructor
		public WordFrame(int mode){ //0-easy 1-medium 2-hard 3-extreme
			this.mode=mode;
			int milliSec=3000;
			switch(mode){
				case 0: milliSec=3000; break;
				case 1: milliSec=2000; break;
				case 2: milliSec=1000; break;
				case 3: milliSec=750; break;
			}
			//Frame Properties
				setSize(WIDTH, HEIGHT);
				setTitle("Pokemon Typer");
				setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				contentPane = getContentPane();
				setLocationRelativeTo(null);
			
		//JPanel Elements
			
			canvas = new WordCanvas(mode);
			canvas.setLayout(null);
			//Adding Textfield
			text = new JTextField();
			text.setEditable(false);
			text.addKeyListener(new KeyboardListener());
			text.setFont(new Font("Arial", Font.BOLD, 20));
			text.setForeground(Color.GRAY);
			text.setBounds(330,555,120,30);
			canvas.add(text);
			contentPane.add(canvas, BorderLayout.CENTER);
			
		//Timer 1 [creates a new word every set time seconds]
			t1 = new Timer(milliSec,this);
			t1.start();
		//Timer 2 (checks every 250ms
			//if a word reached the left part of the screen)
			t2 = new Timer(250,this);
			t2.start();
		//Visibility
			this.setVisible(true);
		}

	//Internal methods
		
		//Create a new word every set time seconds,
		//and check if word reached left board
		@Override
		public void actionPerformed(ActionEvent e) {
			//Stop Game if Either Pokemon have empty life bars
			if(canvas.getFoeHealthBar().isEmpty()||canvas.getPlayerHealthBar().isEmpty()){
				//If Opponent is Empty, the player Wins
				//Subject for change
				if(canvas.getFoeHealthBar().isEmpty()){
					EndGameGUI victory = new EndGameGUI(mode,1);
				}
				else{
					EndGameGUI defeat = new EndGameGUI(mode,0);
				}
				t1.stop();
				t2.stop();
				//MenuGUI menu = new MenuGUI();
				close();
			}
			else{
				//Word Thread Creation
				if(e.getSource()==t1){
					Random r = new Random();
					String randomWord = WordArray.wordRepository[r.nextInt(WordArray.NO_OF_WORDS)];
					Word w = new Word(canvas,randomWord);
					WordThread thread = new WordThread(w);
					sArray.add(randomWord);
					canvas.add(w);
					wThread.add(thread);
					thread.start();
				}
				//Left Board Check
				else if(e.getSource()==t2){
					if(wThread.isEmpty()==false){
						for(int i=0; i<wThread.size();i++){
							if(wThread.get(i).getWord().getforDisposal()==true){
								sArray.remove(i);
								wThread.remove(i);
								canvas.getPlayerHealthBar().damage();
							}
						}//end of for wThread
					}//end of wThread.isEmpty
				}//end of if t2
			}//end of else [No empty Lifebars]
		}//end of actionPerformed [timer activated]
	
		//from external source: Closing Event
		public void close(){
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		}
		
	public boolean isChar(char x){
		if((x>=65 && x<=90) || (x>=97 && x<=122)) 
			return true;
		else
			return false;
	}
		private class KeyboardListener implements KeyListener{
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if (isChar(c)) {
					typedWord = typedWord + c;
					//All words have length 5 only [Clear text after length 5]
					if(typedWord.length()>5){typedWord=Character.toString(c);}
					text.setText(typedWord);
			        repaint();
			        e.consume();
			        text.setForeground(Color.GRAY);
			    }
				else if(c==8&&typedWord.length()!=0){ // backspace
					typedWord = typedWord.substring(0, typedWord.length()-1);
					text.setText(typedWord);
					repaint();
					e.consume();
				}
				//Check if typed word is equal to any moving words
				if(typedWord.length()==5){
					for(int i =0; i<sArray.size();i++){
						if(typedWord.equals(sArray.get(i))){
							typedWord = "";
							sArray.remove(i);
							text.setForeground(Color.BLACK);
							//Kill Thread
							if(!wThread.isEmpty()){
								WordThread t = wThread.get(i);
								t.dispose(); // subject for change
								wThread.remove(i);
							}
							canvas.getFoeHealthBar().damage();
						}//end of typedWord.equals
					}//end of for
				}//end of if typedWord.length
			}//end of keyPressed
	
			@Override
			public void keyReleased(KeyEvent e) {}
	
			@Override
			public void keyTyped(KeyEvent e) {}
		}//end of KeyBoardListener	
		
}