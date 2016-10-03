
public class DataStore {
	private String[] firstGuesses= new String[24];
	private String[] finalGuesses = new String[24];
	private boolean isAssistantRobot;
	private boolean useAssistant;
	
	public DataStore(){
		
	}
	public void setRoundAnswers(String firstAns, String  finalAns, int round){
		 firstGuesses[round-1]=firstAns;
		 finalGuesses[round-1]=finalAns;
	}
	public void setRobot(int robot){
		if(robot==0){
			isAssistantRobot=true;
		}
		else{
			isAssistantRobot=false;
		}
	}
	public void setAssistant(int assistant){
		if(assistant==0){
			useAssistant=false;
		}
		else{
			useAssistant=true;
		}
	}
	public String[] getFirst(){
		return firstGuesses;
	}
	public String[] getFinal(){
		return finalGuesses;
	}
	public boolean getAssitantRobot(){
		return isAssistantRobot;
	}
	public boolean getUseAssistant(){
		return useAssistant;
	}
}
