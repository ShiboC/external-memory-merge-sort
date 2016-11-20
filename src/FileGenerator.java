import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class FileGenerator {
	private int nbElement;
	
	public FileGenerator(int element) {
		this.nbElement = element;
	}
	
	public void generateFile() throws IOException{
		DataOutputStream out = new DataOutputStream(new FileOutputStream("input4.data"));		
	    PrintWriter writer = new PrintWriter("input.data.normal", "UTF-8");
	    
	    for(int i = 0; i < nbElement; i++) {
	    	int toBeWrite = (int) (Math.random() * Integer.MAX_VALUE);
	    	
	    	out.writeInt(toBeWrite);
	    	writer.println(toBeWrite);
	    }
	    out.close();
	    writer.close();
	}
}
