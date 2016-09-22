import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class TriangleAnimation extends JPanel {
	
	private int xA = 150; 
	private int yA = 330;
	private int xB = 350;
	private int yB = 130;
	private int xC = 550;
	private int yC = 330;
	
	private boolean ball = false;
	
	public void startAnim(){
		
		ball = true;
		xA = 150; 
		yA = 350;
		xB = 291;
		yB = 212;
		xC = 432;
		yC = 354;
		
		int step = -2;
		for(int i=0;i<100;i++){
			if(i==50){
				step=step*-1;
			}
			yA=yA+step;
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}

	}
	
	public void movement1() {
		
		ball = false;
		xA = 150; 
		yA = 350;
		xB = 291;
		yB = 212;
		xC = 432;
		yC = 354;
		
		int cStep = 5;
		int xStep = (xB-xA)/50;
		int yStep = (yB-yA)/50;
		for (int i = 0; i < 70; i++) {
			xA = xA + xStep;
			yA = yA + yStep;
			xB = xB - xStep;
			yB = yB - yStep;
			
			if(i%7==0){
				if(i%2==1){
					cStep=cStep*-1;
				}
			}
			if(i%2==0){
				xC = xC + cStep;
			}
			else{
				yC = yC + cStep;
				xC = xC + cStep;
			}
			
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
		
	}
	
	public void movment2(){
		
		ball = false;
		xA = 150; 
		yA = 350;
		xB = 291;
		yB = 212;
		xC = 432;
		yC = 354;
		
		int aStep = 5;
		int xStep = (xC-xB)/50;
		int yStep = (yC-yB)/50;
		for (int i = 0; i < 70; i++) {
			xB = xB + xStep;
			yB = yB + yStep;
			xC = xC - xStep;
			yC = yC - yStep;
			
			if(i%7==0){
				if(i%2==1){
					aStep=aStep*-1;
				}
			}
			if(i%2==0){
				xA = xA + aStep;
			}
			else{
				yA = yA + aStep*2;
				xA = xA + aStep;
			}
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
		}
	}
	public void movment3 (){
		
		ball = false;
		xA = 150; 
		yA = 350;
		xB = 291;
		yB = 212;
		xC = 432;
		yC = 354;
		
		int bStep = 5;
		int xStep = ((xC-xA)/50)+1;
		for (int i = 0; i < 50; i++) {
			xA = xA + xStep;
			xC = xC - xStep;
			
			if(i%7==0){
				if(i%2==1){
					bStep=bStep*-1;
				}
			}
			if(i%2==0){
				xB = xB + bStep;
			}
			else{
				yB = yB + bStep*2;
				xB = xB + bStep;
			}
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		if(ball){
			g.setColor(Color.BLUE);
			g.fillOval(171, 410, 50, 50);
		}
		g.setColor(Color.RED);
		g.fillRect(xA, yA, 100, 120);
		g.fillRect(xB, yB, 100, 120);
		g.fillRect(xC, yC, 100, 120);
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(675,600);
	}

}
