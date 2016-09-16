import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LineAnimationFrame extends JFrame {
	
	LineAnimation animationPanel;
	//LineAnimation aP;
	public LineAnimationFrame() {
		super("Animation Test");
		
		//this.setSize(800, 600);
		animationPanel =new LineAnimation(); 
		//aP = new LineAnimation();
		
		this.add(animationPanel, BorderLayout.CENTER);
		//this.add(aP, BorderLayout.CENTER);

		JPanel south = new JPanel(new BorderLayout());
		JPanel labels = new JPanel(new GridLayout(1,5));
		labels.add(new JLabel(""));
		labels.add(new JLabel("A"));
		labels.add(new JLabel("B"));
		labels.add(new JLabel("C"));
		south.add(labels,BorderLayout.NORTH);
		JPanel input = new JPanel(new FlowLayout());
		input.add(new JTextField("First Guess"));
		input.add(new JTextField("Final Guess"));
		input.add(new JButton("Next"));
		south.add(input,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
		
		this.pack();
	
	}
	
	public void startAnimation() {
		//new Thread(new AnimationRunner(animationPanel)).start();
		new Thread(new LineAnimationRunner(animationPanel)).start();
	}

	
	

}
