import java.io.IOException;

public class Main {

		public static void main(String[] args) throws IOException
		{
			String inputfilePath = "input";
			String inputfileName = "external_mway_merge_sort.data";
			String outputfilePath = "output";
			boolean isGenerateFile = false; //generate new file or use the existing one
			boolean debug = false; //print normal file with readable int
			
			int M = 1000;
			int d = 223;
			int N = 2000000;
			int B = 4096;
			
			if(isGenerateFile) {
				FileGenerator generator = new FileGenerator(N, inputfilePath, inputfileName);
				generator.generateFile();
			}
			
			IOStream4_Input input = new IOStream4_Input(inputfilePath + "\\" + inputfileName, B);
			ExternalMultiWayMergeSort mergeSort = new ExternalMultiWayMergeSort(M, d, input, outputfilePath, B, debug);
			mergeSort.sort();
			System.out.println("===========DONE===========");
			long[] elapsedSystemTimeUserTime = mergeSort.getElapsedTime();
			System.out.println("Elapsed Time (in SystemTime & UserTime):" 
					+ elapsedSystemTimeUserTime[0] + ";" + elapsedSystemTimeUserTime[1]);
			
		}
}
