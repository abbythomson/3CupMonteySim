import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
                TriAnimationFrame triFrame = new TriAnimationFrame();
                triFrame.setVisible(true);
                triFrame.startAnimation();
            	/*LineAnimationFrame lineFrame = new LineAnimationFrame();
                lineFrame.setVisible(true);
                lineFrame.startAnimation();*/
                
            }
        });
	}

}
