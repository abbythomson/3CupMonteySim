
public class LineAnimationRunner implements Runnable {
	
	private LineAnimation panel;
	
	public LineAnimationRunner(LineAnimation panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		panel.startAnim();
		for(int i = 0; i < 24; i++){
			double randMove = (int)(Math.random()*3+1);
			if(randMove==1){
				System.out.println("A");
				panel.movment1();
			}
			else if (randMove==2){
				System.out.println("B");
				panel.movment2();
			}
			else{
				System.out.println("C");
				panel.movment3();
			}	
		}
		
		
	}

}
