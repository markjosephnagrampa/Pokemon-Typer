package WordThreading;

public class WordThread extends Thread {
	   /**
	      Constructs the thread.
	      @word the word thread
	   */
	   public WordThread(Word word) { w = word; }

	   public void run() {
	      try {
	         for(;;) {
	        		 w.move(); sleep(5);
	        	 }
	      }
	      catch (InterruptedException exception) {
	    	  return;
	      }
	     
	   }
	   //subject for change
	   public void dispose(){
		   w.setforDisposal(true);
		   w.repaint();
		   this.stop();
	   }
	   //getter
	   	public Word getWord(){
	   		return w;
	   	}
	  //fields 
	 private Word w;
	}
