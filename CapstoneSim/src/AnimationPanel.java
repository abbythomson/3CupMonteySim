import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel {
	
	private int x = 0;
	private int y = 0;
	
	
	public void movement1() {
		x = 0; 
		y = 0;
		for (int i = 0; i < 600; i++) {
			x = i;
			y = i;
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.BLUE);
		g.fillOval(x, y,  100,  50);		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}

}
