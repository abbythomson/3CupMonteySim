import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class LineAnimation extends JPanel{
	private int xA = 200; 
	private int yA = 330;
	private int xB = 750;
	private int yB = 330;
	private int xC = 1300;
	private int yC = 330;
	private boolean ball = false;
	private int ballX = 250;
	private int ballY = 425;
	
	public void liftA(){
		ball=true;
		int step = -4;
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
	
	public void liftB(){
		ball=true;
		ballX = 380;
		ballY = 330;
		int step = -2;
		for(int i=0;i<100;i++){
			if(i==50){
				step=step*-1;
			}
			yB=yB+step;
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		reset();
		ball=false;		
	}
	
	public void liftC(){
		ball=true;
		ballX = 620;
		ballY = 330;
		int step = -2;
		for(int i=0;i<100;i++){
			if(i==50){
				step=step*-1;
			}
			yC=yC+step;
			
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		reset();
		ball=false;
	}
	public void movment1(){
		int xStep = 550/50;
				
		for(int i=0; i<50;i++){
			xA = xA + xStep;
			xB = xB - xStep;
			if(i<50){
				yA--;
				yB++;
			}
			else{
				yA++;
				yB--;
			}
			repaint();
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	public void movment2(){
	
		int xStep = 550/50;
				
		for(int i=0; i<50;i++){
			xB = xB + xStep;
			xC = xC - xStep;
			
			if(i<25){
				yB--;
				yC++;
			}
			else{
				yB++;
				yC--;
			}
			
			repaint();
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	public void movment3(){
		
		int xStep = 1100/100;
				
		for(int i=0; i<100;i++){
			xA = xA + xStep;
			xC = xC - xStep;
			if(i<50){
				yA--;
				yC++;
			}
			else{
				yA++;
				yB--;
			}
			repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {}
		}
		reset();
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, this.getWidth(),this.getHeight());
		if(ball){
			g.setColor(Color.BLUE);
			g.fillOval(ballX, ballY, 100, 100);
		}
		g.setColor(Color.RED);
		g.fillRect(xA, yA, 200, 240);
		g.setColor(Color.BLACK);
		g.drawRect(xA, yA, 200, 240);
		g.setColor(Color.RED);
		g.fillRect(xB, yB, 200, 240);
		g.setColor(Color.BLACK);
		g.drawRect(xB, yB, 200, 240);
		g.setColor(Color.RED);
		g.fillRect(xC, yC, 200, 240);
		g.setColor(Color.BLACK);
		g.drawRect(xC, yC, 200, 240);		
		
	}
	private void reset(){
		xA = 200; 
		yA = 330;
		xB = 850;
		yB = 330;
		xC = 1500;
		yC = 330;
		ballX = 250;
		ballY = 425;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1900,875);
	}
}
