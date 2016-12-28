import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException
	{
		boolean isGenerateFile = false; //generate new file or use the existing one
		boolean debug = false; //print normal file with readable int
		
		int M = 1000;
		int d = 223;
		int N = 2000000;
		int B = 32768;
		int nn = 10;
		
		int Narray[] = {15625,31250,62500,
				125000,250000,500000,
				1000000,2000000,
				4000000,8000000,16000000,32000000};
		
		// N test
		M = 250000;
		d = 2;
		B = 32768;
		System.out.println("Increase the number of N using M=" + M + " d=" + d);
		
		for (int ii = 5; ii <= 11; ii++ ){
			MergeSortTest mergeSort = new MergeSortTest(isGenerateFile, debug, M, d, Narray[ii], B, nn);
			long result[] = mergeSort.run();
			
			System.out.println("Average time for External Multi-way Merge-sort with M=" + M + " d=" + d + " Nelements="
					+ Narray[ii] + " times=" + nn + "(in SystemTime & UserTime);" 
					+ result[0] + ";" + result[1] 
			);
		}
	}
}
