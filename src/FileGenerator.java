import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class FileGenerator {
	private int nbElement;
	
	public FileGenerator(int element) {
		this.nbElement = element;
	}
	
	public void generateFile() throws FileNotFoundException, UnsupportedEncodingException{
	    PrintWriter writer = new PrintWriter("input.data", "UTF-8");
	    for(int i = 0; i < nbElement; i++) {
	    	writer.println((int)(Math.random() * Integer.MAX_VALUE));
	    }
	    writer.close();
	}
}
