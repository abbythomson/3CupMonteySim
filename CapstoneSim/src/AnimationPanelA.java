import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class AnimationPanelA extends JPanel {
	
	
	private int xA = 150; 
	private int yA = 330;
	private int xB = 350;
	private int yB = 150;
	private int xC = 550;
	private int yC = 330;
	
	
	public void movement1() {
		xA = 150; 
		yA = 330;
		xB = 350;
		yB = 130;
		xC = 550;
		yC = 330;
		int cStep = 3;
		int xStep = (xB-xA)/50;
		int yStep = (yB-yA)/50;
		for (int i = 0; i < 50; i++) {
			xA = xA + xStep;
			yA = yA + yStep;
			xB = xB - xStep;
			yB = yB - yStep;
			
			if(i%5==0){
				
				cStep=cStep*-1;
			}
			xC = xC + cStep;
			
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
		
	}
	
	public void movment2(){
		xA = 150; 
		yA = 330;
		xB = 350;
		yB = 130;
		xC = 550;
		yC = 330;
		int aStep = 3;
		int xStep = (xC-xB)/50;
		int yStep = (yC-yB)/50;
		for (int i = 0; i < 50; i++) {
			xB = xB + xStep;
			yB = yB + yStep;
			xC = xC - xStep;
			yC = yC - yStep;
			
			if(i%5==0){
				
				aStep=aStep*-1;
			}
			xA = xA + aStep;
			
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
	}
	public void movment3 (){
		xA = 150; 
		yA = 330;
		xB = 350;
		yB = 130;
		xC = 550;
		yC = 330;
		int bStep = 5;
		int xStep = (xC-xA)/50;
		for (int i = 0; i < 50; i++) {
			xA = xA + xStep;
			xC = xC - xStep;
			
			if(i%5==0){
				
				bStep=bStep*-1;
			}
			xB = xB + bStep;
			
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(xA, yA, 75, 90);
		g.fillRect(xB, yB, 75, 90);
		g.fillRect(xC, yC, 75, 90);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}

}
