import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadingFile {
	
	public static void main(String[] args) {
		
		try {
			
			//Reading requires a scanner
			Scanner outputTxt = new Scanner(new FileInputStream("itemsList.txt"));
			
			
			// Reading the file while there's a next line
			while(outputTxt.hasNextLine()) {
				String line = outputTxt.nextLine();
				System.out.println(line);
			}
			
			outputTxt.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
}