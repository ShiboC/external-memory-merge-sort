import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		boolean isGenerateFile = false; //generate new file or use the existing one
		boolean debug = false; //print normal file with readable int
		
		int M = 250000;
		int d = 64;
		int N = 32000000;
		int B = 32768;
		int nn = 1;
		
		MergeSortTest mergeSort = new MergeSortTest(isGenerateFile, debug, M, d, N, B, nn);
		long result[] = mergeSort.run();
		
		System.out.println("Average time for External Multi-way Merge-sort with M=" + M + " d=" + d + " Nelements="
				+ N + " times=" + nn+ "(in SystemTime & UserTime);" 
				+ result[0] + ";" + result[1] 
				);
	}

}
