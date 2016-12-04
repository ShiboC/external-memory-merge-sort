import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

		public static void main(String[] args) throws IOException
		{
//			// Check IOStream1_Output
//			IOStream1_Output ioStream1_Output = new IOStream1_Output();
//			ioStream1_Output.create();
//			ioStream1_Output.write(1001);
//			ioStream1_Output.close();
//			
//			// Check IOStream1_Input
//			IOStream2_Input ioStream1_Input = new IOStream2_Input("input6.data");
//			ioStream1_Input.open();
//			ioStream1_Input.read_all();
			
			FileGenerator generator = new FileGenerator(1000000, "external_mway_merge_sort.data");
			generator.generateFile();
			
//			IOStream2_Output ioStream2_Input = new IOStream2_Output("input_test.data");
//			ioStream2_Input.create();
//			ioStream2_Input.write(100);
//			ioStream2_Input.close();
//			
			
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
//			ExternalMultiWayMergeSort mergeSort = new ExternalMultiWayMergeSort("A", 1, 1, x);
		}
}
