
public class showCorrectRunner implements Runnable{
	private String toRun;
	private LineAnimation panel;
	public showCorrectRunner(LineAnimation panel, String correct){
		toRun = correct;
		this.panel=panel;
		
	}
	@Override
	public void run() {
		if(toRun.equalsIgnoreCase("a")){
			panel.liftA();
		}
		else if(toRun.equalsIgnoreCase("b")){
			panel.liftB();
		}
		else{
			panel.liftC();
		}
		
	}

}
