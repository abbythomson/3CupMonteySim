
public class AnimationRunner implements Runnable {
	
	private AnimationPanelA panel1;
	private AnimationPanelB panel2;
	
	public AnimationRunner(AnimationPanelA panel) {
		this.panel1 = panel;
	}
	public AnimationRunner(AnimationPanelB panel){
		this.panel2 = panel;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			double randMove = (int)(Math.random()*3+1);
			System.out.println("Random " + randMove);
			if(randMove==1){
				System.out.println("1");
				//panel1.movement1();
				panel2.movment1();
			}
			else if (randMove==2){
				System.out.println("2");
				//panel1.movment2();
				panel2.movment2();
			}
			else{
				System.out.println("3");
				//panel1.movment3();
				panel2.movment3();
			}	
		}
		
	}

}
