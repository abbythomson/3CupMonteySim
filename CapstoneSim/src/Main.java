import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	//int robotAssist = JOptionPane.showConfirmDialog(null, "R?", "R?", JOptionPane.YES_NO_OPTION);
            	//String currentEmail = JOptionPane.showInputDialog("Please enter your Augustana Email");
            	JOptionPane.showMessageDialog(null, "Ready?");
                /*TriAnimationFrame triFrame = new TriAnimationFrame();
                triFrame.setVisible(true);
                triFrame.startAnimation();*/
            	LineAnimationFrame lineFrame = new LineAnimationFrame();
                lineFrame.setVisible(true);
                lineFrame.startAnimation();
                //RecordWriter writer = new RecordWriter();
                /*try {
					writer.writeData(currentEmail);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
                
            }
        });
	}
}


