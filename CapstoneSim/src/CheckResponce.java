
public class CheckResponce {
	private static String[] firstGuessList = new String[20];
	private static String[] finalGuessList = new String[20];
	private static String[] correctLocList = new String[]{"b","a","c","c","a","c","b","b","c","a","b","a","a","a","c","b","a","c","c","a","b","b","c","a"};
	private static int numEntries=0;
	public static boolean checkAnswer(String guess, int round){
		if(guess.equalsIgnoreCase(correctLocList[round-1])){
			numEntries++;
			return true;
		}
		return false;
	}
	
	public void updataAnswerLists(String firstGuess, String secondGuess, int round){
		firstGuessList[round-1]=firstGuess;
		finalGuessList[round-1]=secondGuess;
	}
	
	public static String[] getFirstGuessList(){
		return firstGuessList;
	}
	
	public static String[] getFinalGuessList(){
		return finalGuessList;
	}
	
	public static int getNumEntries(){
		return numEntries;
	}
}
