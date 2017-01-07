import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class FileGenerator {
	// number of integer to write
	private int nbElement;
	// file name
	private String filename;
	// path of the file
	private String path;
	
	public FileGenerator(int element, String path, String filename) {
		this.nbElement = element;
		this.filename = filename;
		this.path = path;
	}
	
	public void generateFile() throws IOException{
		File f = new File(path);
		f.mkdir();
		
		// for checking purpose, 
		// write the integer into disk in human readable format
//		PrintWriter writer = new PrintWriter(path + "\\" + filename + ".normal", "UTF-8");
		
		IOStream2_Output out = new IOStream2_Output(path + "\\" + filename);
		out.create();
		for(int i = 0; i < nbElement; i++) {
	    	Random rand = new Random();
	    	boolean isPositive = rand.nextBoolean();
	    	int toWrite = rand.nextInt(Integer.MAX_VALUE);
	    	
			toWrite = isPositive ? toWrite : (toWrite * -1);
	    	
	    	out.write(toWrite);
//	    	writer.println(toWrite);
	    }
	    out.close();
//	    writer.close();
	}
	
	// main files to generate the input for Stream Test
	public static void main(String args[]) throws IOException{
		// create an array list of file generator
		ArrayList<FileGenerator> fileGenerator = new ArrayList<FileGenerator>();
		// path file
		String path = "C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\";
		// add file generator into the array list
		for(int ii = 1; ii <= 30; ii++){
			fileGenerator.add(new FileGenerator(32000000,path,("testInput" + ii + ".data")));
		}
		// generate the file
		for(int ii = 0; ii < 30; ii++){
			fileGenerator.get(ii).generateFile();
		}
	}
}
