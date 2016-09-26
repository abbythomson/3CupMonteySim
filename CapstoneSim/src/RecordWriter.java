import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RecordWriter {
	public static void writeData(String emailAddress) throws IOException {
		File emails = new File("Emails");
		FileWriter emailWriter = new FileWriter(emails, true);
		emailWriter.write(emailAddress+"\n");
		emailWriter.close();
		File folder = new File("Trials");
		File[] listOfFiles = folder.listFiles();
		int curTrialNum = listOfFiles.length+1;
		File current = new File("Trials/Trial" + curTrialNum);
		FileWriter fw = new FileWriter(current, false);
		PrintWriter pw = new PrintWriter(fw);
		pw.close();
		fw.close();
	}

}
