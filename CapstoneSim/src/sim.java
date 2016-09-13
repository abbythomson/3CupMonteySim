import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class sim implements ActionListener, ChangeListener {

	public static void main(String[] args) {
		sim gui = new sim();
	}

	private JFrame frame;
	private JPanel jp;
	private Graphics g;
	
	
	public sim () {
		frame = new JFrame("3 Cup Monte");
		frame = new JFrame("Fun With Color");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400, 300));
		frame.setLayout(new BorderLayout());
		jp = new JPanel();
		g = jp.getGraphics();
		
		
		
	}
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
