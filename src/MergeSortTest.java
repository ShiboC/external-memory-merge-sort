import java.io.File;
import java.io.IOException;

public class MergeSortTest {
	
	private String inputfilePath;
	private String inputfileName;
	private String outputfilePath;
	private boolean debug;
	
	private int M;
	private int d;
	private int N;
	private int B;
	private int nn;
	
	public MergeSortTest(String inputFilePath, String outputFilePath, String fileName, boolean debug, int M, int d, int N, int B, int nn) {
		inputfilePath = inputFilePath;
		inputfileName = fileName;
		outputfilePath = outputFilePath;
		this.debug = debug;
		this.M = M;
		this.d = d;
		this.N = N;
		this.B = B;
		this.nn = nn > 0 ? nn : 1; 
	}
	
	public long[] run() throws IOException, InterruptedException{
		
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;		
		
		for (int i = 0; i < nn; i++) {
			System.gc();
			deleteFolder(outputfilePath);
			Thread.sleep(500);
			
			IOStream4_Input input = new IOStream4_Input(inputfilePath + "\\" + inputfileName, B);

			ExternalMultiWayMergeSort mergeSort = new ExternalMultiWayMergeSort(M, d, input, outputfilePath, B, debug);
			mergeSort.sort();

			// Get execution time for this run
			long[] elapsedSystemTimeUserTime = mergeSort.getElapsedTime();
			
			// Add execution time
			average[0] += elapsedSystemTimeUserTime[0];
			average[1] += elapsedSystemTimeUserTime[1];
			Thread.sleep(500);
		}
		
		average[0] /= nn;
		average[1] /= nn;
		
		return average;
		
	}
	
	private boolean deleteFolder(String folderPath) {
		File folder = new File(folderPath);
		if (folder.exists()) {
			// Check if the file is a directory
			if (folder.isDirectory()) {
				if ((folder.list()).length > 0) {
					// Delete all files
					for(String s:folder.list()){
						deleteFolder(folderPath+"\\"+s);
					}
				}
			}
			boolean result = folder.delete();
			
			return result;
		} else {
			return false;
		}
	}
}
