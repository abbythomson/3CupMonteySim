
public class TriAnimationRunner implements Runnable {
	
	private TriangleAnimation panel;
	
	public TriAnimationRunner(TriangleAnimation panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		panel.startAnim();
		for(int i = 0; i < 20; i++){
			double randMove = (int)(Math.random()*3+1);
			if(randMove==1){
				panel.movement1();
			}
			else if (randMove==2){
				panel.movment2();
			}
			else{
				panel.movment3();
			}	
		}
	}

}
