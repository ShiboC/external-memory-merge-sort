import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
//			IOStream1_Input ioStream1_Input = new IOStream1_Input();
//			ioStream1_Input.open();
//			ioStream1_Input.real_all();
			
			List<String> fileName = new ArrayList<>();
			fileName.add("input_multiway0.data");
			fileName.add("input_multiway1.data");
			fileName.add("input_multiway2.data");
			
			MultiWayMerger merger = new MultiWayMerger();
			merger.merge(fileName);
		}
}
