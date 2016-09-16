import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AnimationPanelB extends JPanel{
	private int xA = 110; 
	private int yA = 330;
	private int xB = 360;
	private int yB = 330;
	private int xC = 610;
	private int yC = 330;
	
	public void movment1(){
		xA = 110; 
		yA = 330;
		xB = 360;
		yB = 330;
		xC = 610;
		yC = 330;
		int xStep = 250/25;
				
		for(int i=0; i<25;i++){
			xA = xA + xStep;
			xB = xB - xStep;
			repaint();
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {}
		}
	}
	
	public void movment2(){
		xA = 110; 
		yA = 330;
		xB = 360;
		yB = 330;
		xC = 610;
		yC = 330;
		int xStep = 250/25;
				
		for(int i=0; i<25;i++){
			xB = xB + xStep;
			xC = xC - xStep;
			repaint();
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {}
		}
	}
	
	public void movment3(){
		xA = 110; 
		yA = 330;
		xB = 360;
		yB = 330;
		xC = 610;
		yC = 330;
		int xStep = 500/100;
				
		for(int i=0; i<100;i++){
			xA = xA + xStep;
			xC = xC - xStep;
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(xA, yA, 90, 100);
		g.fillRect(xB, yB, 90, 100);
		g.fillRect(xC, yC, 90, 100);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
}
