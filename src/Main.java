import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {

		public static void main(String[] args) throws IOException
		{
			String inputfilePath = "input";
			String inputfileName = "external_mway_merge_sort.data";
			String outputfilePath = "output";
			boolean isGenerateFile = true;
			
			int M = 100;
			int d = 80;
			int N = 20000;
			
			if(isGenerateFile) {
				FileGenerator generator = new FileGenerator(N, inputfilePath, inputfileName);
				generator.generateFile();
			}
			
			
//			List<String> fileName = new ArrayList<>();
//			fileName.add("input_multiway0.data");
//			fileName.add("input_multiway1.data");
//			fileName.add("input_multiway2.data");
//			
//			List<IOStream2_Input> inputStream = new ArrayList<IOStream2_Input>();
//			for (String string : fileName) {
//				IOStream2_Input newInputStream = new IOStream2_Input(string); 
//				newInputStream.open();
//				inputStream.add(newInputStream);
//			}
//			
			
//			MultiWayMerger merger = new MultiWayMerger(inputStream);
//			merger.merge();
//			IOStream1_Input x = new IOStream1_Input();
			
			
			IOStream2_Input input = new IOStream2_Input(inputfilePath + "\\" + inputfileName);
			IOStream2_Output output = new IOStream2_Output("output.data");
			ExternalMultiWayMergeSort mergeSort = new ExternalMultiWayMergeSort(M, d, input, output, outputfilePath);
			mergeSort.sort();
			
		}
}
