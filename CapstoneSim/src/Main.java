import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	int robotAssist = JOptionPane.showConfirmDialog(null, "R?", "R?", JOptionPane.YES_NO_OPTION);
            	String currentEmail = JOptionPane.showInputDialog("Please enter your Augustana Email");
            	JOptionPane.showMessageDialog(null, "Ready?");
            	LineAnimationFrame lineFrame = null;
                RecordWriter writer = new RecordWriter();
            	DataStore data = new DataStore();
            	data.setRobot(robotAssist);
				try {
					lineFrame = new LineAnimationFrame(data,writer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                lineFrame.setVisible(true);
                lineFrame.startAnimation();
                try {
					writer.updataEmailList(currentEmail);
				} catch (IOException e) {
					e.printStackTrace();
				}
                
            }
        });
	}
}

  
