import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class FileGenerator {
	private int nbElement;
	private String filename;
	private String path;
	
	public FileGenerator(int element, String path, String filename) {
		this.nbElement = element;
		this.filename = filename;
		this.path = path;
	}
	
	public void generateFile() throws IOException{
		File f = new File(path);
		f.mkdir();
		
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
	
	public static void main(String args[]) throws IOException{
		ArrayList<FileGenerator> fileGenerator = new ArrayList<FileGenerator>();
		String path = "C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\";
		for(int ii = 1; ii <= 30; ii++){
			fileGenerator.add(new FileGenerator(32000000,path,("testInput" + ii + ".data")));
		}
		
		for(int ii = 0; ii < 30; ii++){
			fileGenerator.get(ii).generateFile();
		}
//		FileGenerator fileGenerator = new FileGenerator(32000000,"C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\","test.data");
//		fileGenerator.generateFile();
	}
}
