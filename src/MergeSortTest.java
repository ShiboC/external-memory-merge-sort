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
	
	public long[] run() throws IOException{
		
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;		
		
		for (int i = 0; i < nn; i++) {
//			System.out.println("***********RUN "+(i+1)+"***********");
//			IOStream4_Input input = new IOStream4_Input(inputfilePath + "\\" + inputfileName, B);
			IOStream2_Input input = new IOStream2_Input(inputfilePath + "\\" + inputfileName);

			ExternalMultiWayMergeSort mergeSort = new ExternalMultiWayMergeSort(M, d, input, outputfilePath, B, debug);
			mergeSort.sort();
//			System.out.println("===========DONE===========");
			long[] elapsedSystemTimeUserTime = mergeSort.getElapsedTime();
//			System.out.println("Elapsed Time (in SystemTime & UserTime):" 
//					+ elapsedSystemTimeUserTime[0] + ";" + elapsedSystemTimeUserTime[1]);
			
			average[0] += elapsedSystemTimeUserTime[0];
			average[1] += elapsedSystemTimeUserTime[1];
		}
		
		average[0] /= nn;
		average[1] /= nn;
		
		return average;
		
	}
}
