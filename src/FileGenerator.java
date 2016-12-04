import java.io.IOException;
import java.io.PrintWriter;


public class FileGenerator {
	private int nbElement;
	private String filename;
	
	public FileGenerator(int element, String filename) {
		this.nbElement = element;
		this.filename = filename;
	}
	
	public void generateFile() throws IOException{
		PrintWriter writer = new PrintWriter(filename + ".normal", "UTF-8");
		
		IOStream2_Output out = new IOStream2_Output(filename);
		out.create();
		for(int i = 0; i < nbElement; i++) {
	    	int toWrite = (int) (Math.random() * Integer.MAX_VALUE);
	    	
	    	out.write(toWrite);
	    	writer.println(toWrite);
	    }
	    out.close();
	    writer.close();
	}
}
