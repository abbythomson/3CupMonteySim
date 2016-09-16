
public class LineAnimationRunner implements Runnable {
	
	private LineAnimation panel;
	
	public LineAnimationRunner(LineAnimation panel) {
		this.panel = panel;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			double randMove = (int)(Math.random()*3+1);
			System.out.println("Random " + randMove);
			if(randMove==1){
				System.out.println("1");
				panel.movment1();
			}
			else if (randMove==2){
				System.out.println("2");
				panel.movment2();
			}
			else{
				System.out.println("3");
				panel.movment3();
			}	
		}
		
	}

}
