import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RecordWriter {
	private static String email;
	public void updataEmailList(String emailAddress) throws IOException{
		email=emailAddress;
		File emails = new File("Emails");
		FileWriter emailWriter = new FileWriter(emails, true);
		emailWriter.write(emailAddress+"\n");
		emailWriter.close();
		
	}
	public static void writeData(DataStore data) throws IOException {
		File folder = new File("Trials");
		File[] listOfFiles = folder.listFiles();
		int curTrialNum = listOfFiles.length+1;
		File current = new File("Trials/Trial" + curTrialNum);	
		FileWriter fw = new FileWriter(current, true);
		PrintWriter pw = new PrintWriter(fw);
		if(data.getAssitantRobot()){
			fw.write("Assistant: Robot\n");
		}
		else{
			fw.write("Assistant: Human\n");
		}
		String[] firstA = data.getFirst();
		String[] finalA = data.getFinal();
		fw.write("Guesses:\n");
		for(int i=0;i<firstA.length;i++){
			fw.write("["+firstA[i]+", "+finalA[i]+"] ");
		}
		fw.write("\n");
		if(data.getUseAssistant()){
			fw.write("Used Assistant");
		}
		else{
			fw.write("Did NOT use Assistant");
		}
		pw.close();
		fw.close();
	}
	public static void addEntry(){
		File entries = new File("Raffel Entries");
		try {
			FileWriter writer = new FileWriter(entries,true);
			writer.write(email+"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
