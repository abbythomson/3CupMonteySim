
public class AnimationRunner implements Runnable {
	
	private AnimationPanel panel;
	
	public AnimationRunner(AnimationPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		// for loop?
		panel.movement1();

		
	}

}
