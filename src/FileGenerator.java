import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


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
		
		PrintWriter writer = new PrintWriter(path + "\\" + filename + ".normal", "UTF-8");
		
		IOStream2_Output out = new IOStream2_Output(path + "\\" + filename);
		out.create();
		for(int i = 0; i < nbElement; i++) {
	    	int toWrite = (int) (Math.random() * Integer.MAX_VALUE);
	    	
	    	out.write(toWrite);
	    	writer.println(toWrite);
	    }
	    out.close();
	    writer.close();
	}
	
	public static void main(String args[]) throws IOException{
//		ArrayList<FileGenerator> fileGenerator = new ArrayList<FileGenerator>();
//		for(int ii = 1; ii <= 30; ii++){
////			fileGenerator.add(new FileGenerator(10000000,fName));
//		}
//		for(int ii = 0; ii < 30; ii++){
//			fileGenerator.get(ii).generateFile();
//		}
		FileGenerator fileGenerator = new FileGenerator(4000000,"C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\","test.data");
		fileGenerator.generateFile();
	}
}
