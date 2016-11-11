import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class FileGenerator {
	private int elementNo;
	
	public FileGenerator(int element) {
		this.elementNo = element;
	}
	
	public void generateFile() throws FileNotFoundException, UnsupportedEncodingException{
	    PrintWriter writer = new PrintWriter("input.data", "UTF-8");
	    for(int i = 0; i < elementNo; i++) {
	    	writer.println((int)(Math.random() * Integer.MAX_VALUE));
	    }
	    writer.close();
	}
}
