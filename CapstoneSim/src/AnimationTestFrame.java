import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnimationTestFrame extends JFrame {
	
	AnimationPanel animationPanel;
	
	public AnimationTestFrame() {
		super("Animation Test");
		
		//this.setSize(800, 600);
		animationPanel =new AnimationPanel(); 
		
		this.add(animationPanel, BorderLayout.CENTER);

		this.add(new JButton("Hi there!"), BorderLayout.SOUTH);
		
		this.pack();
		
	}
	
	public void startAnimation() {
		new Thread(new AnimationRunner(animationPanel)).start();
	}

	
	

}
