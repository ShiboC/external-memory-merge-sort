import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException
	{
		boolean isGenerateFile = true; //generate new file or use the existing one
		boolean debug = false; //print normal file with readable int
		List<String> listResult = new ArrayList<String>();
		
		int M = 250000;
		int d = 64;
		int N = 32000000;
		int B = 32768;
		int nn = 1;
		
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
			String inputFileName = "input" + Narray[ii] + ".data";
			MergeSortTest mergeSort = new MergeSortTest(isGenerateFile, inputFileName, debug, M, d, Narray[ii], B, nn);
			long result[] = mergeSort.run();
			
			String str = "Average time for External Multi-way Merge-sort with M=" + M + " d=" + d + " Nelements="
					+ Narray[ii] + " times=" + nn + "(in SystemTime & UserTime);" 
					+ result[0] + ";" + result[1] ;
			System.out.println(str);
			listResult.add(str);
		}
		
		System.out.println("============FINAL RESULT============");
		for(String s : listResult) {
			System.out.println(s);
		}
	}
}
