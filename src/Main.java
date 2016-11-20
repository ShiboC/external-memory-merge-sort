import java.io.IOException;
import java.util.ArrayList;

public class Main {

		public static void main(String[] args) throws IOException
		{
			ArrayList<Integer> result;
			
			// Check IOStream1_Output
			IOStream1_Output ioStream1_Output = new IOStream1_Output();
			ioStream1_Output.create();
			ioStream1_Output.write(1000);
			ioStream1_Output.close();
			
			// Check IOStream1_Input
//			IOStream1_Input ioStream1_Input = new IOStream1_Input();
//			ioStream1_Input.open();
//			result = ioStream1_Input.read_all();
//			
//			System.out.println("Check IOStream1_Input");
//			for(int ii = 0; ii < result.size(); ii++)
//				System.out.println(result.get(ii));
			
			// Check IOStream3_Input
//			IOStream3_Input ioStream3_Input = new IOStream3_Input(4);
//			ioStream3_Input.open();
//			result = ioStream3_Input.read_all();
//			ioStream3_Input.close();
//			System.out.println("Check IOStream3_Input");
//			for(int ii = 0; ii < result.size(); ii++)
//				System.out.println(result.get(ii));
			
			// Check IOStream3 Output
//			IOStream3_Output ioStream3_Output = new IOStream3_Output(4);
//			ioStream3_Output.create();
//			ioStream3_Output.write(10);
//			ioStream3_Output.close();
			
		}
}
