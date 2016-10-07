
public class CheckResponce {
	private static String[] firstGuessList = new String[24];
	private static String[] finalGuessList = new String[24];
	private static String[] correctLocList = new String[]{"b","a","c","c","a","c","b","b","c","a","b","a","a","a","c","b","a","c","c","a","b","b","c","a"};
	public static boolean checkAnswer(String guess, int round){
		if(guess.equalsIgnoreCase(correctLocList[round-1])){
			return true;
		}
		return false;
	}
	public static String getCorrect(int round){
		return correctLocList[round-1];
	}
	public static void updataAnswerLists(String firstGuess, String secondGuess, int round){
		firstGuessList[round-1]=firstGuess;
		finalGuessList[round-1]=secondGuess;
	}
	
	public static String[] getFirstGuessList(){
		return firstGuessList;
	}
	
	public static String[] getFinalGuessList(){
		return finalGuessList;
	}
	
}
