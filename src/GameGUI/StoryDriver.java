package GameGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

public class StoryDriver extends JFrame {
	//fields
	private StoryGUI sg;
	private int spaceCtr=0;
	public StoryDriver(){
		sg = new StoryGUI(this);
		add(sg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Story");
        setResizable(false);
        setVisible(true);
	}
	//Remedial Method
	public void loadNext(){
			new MenuGUI();
			close();
	}
	
	public void close(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}

	public int getSpaceCtr() {
		return spaceCtr;
	}

	public void setSpaceCtr(int spaceCtr) {
		this.spaceCtr = spaceCtr;
	}


}
