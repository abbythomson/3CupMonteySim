import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class LineAnimation extends JPanel{
	private int xA = 115; 
	private int yA = 330;
	private int xB = 355;
	private int yB = 330;
	private int xC = 595;
	private int yC = 330;
	private boolean ball = false;
	
	public void startAnim(){
		ball=true;
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
		reset();
		ball=false;
	}
	public void movment1(){
		int xStep = 240/30;
				
		for(int i=0; i<30;i++){
			xA = xA + xStep;
			xB = xB - xStep;
			if(i<15){
				yA--;
				yB++;
			}
			else{
				yA++;
				yB--;
			}
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	public void movment2(){
	
		int xStep = 240/30;
				
		for(int i=0; i<30;i++){
			xB = xB + xStep;
			xC = xC - xStep;
			
			if(i<15){
				yB--;
				yC++;
			}
			else{
				yB++;
				yC--;
			}
			
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	public void movment3(){
		
		int xStep = 480/80;
				
		for(int i=0; i<80;i++){
			xA = xA + xStep;
			xC = xC - xStep;
			if(i<40){
				yA--;
				yC++;
			}
			else{
				yA++;
				yB--;
			}
			repaint();
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		if(ball){
			g.setColor(Color.BLUE);
			g.fillOval(140, 400, 50, 50);
		}
		g.setColor(Color.RED);
		g.fillRect(xA, yA, 100, 120);
		g.setColor(Color.BLACK);
		g.drawRect(xA, yA, 100, 120);
		g.setColor(Color.RED);
		g.fillRect(xB, yB, 100, 120);
		g.setColor(Color.BLACK);
		g.drawRect(xB, yB, 100, 120);
		g.setColor(Color.RED);
		g.fillRect(xC, yC, 100, 120);
		g.setColor(Color.BLACK);
		g.drawRect(xC, yC, 100, 120);		
		
	}
	private void reset(){
		xA = 115; 
		yA = 330;
		xB = 355;
		yB = 330;
		xC = 595;
		yC = 330;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800,600);
	}
}
