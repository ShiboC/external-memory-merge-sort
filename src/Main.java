import java.io.IOException;

public class Main {

		public static void main(String[] args) throws IOException
		{
			// Check IOStream1_Output
			IOStream1_Output ioStream1_Output = new IOStream1_Output();
			ioStream1_Output.create();
			ioStream1_Output.write(1000);
			ioStream1_Output.close();
			
			// Check IOStream1_Input
			IOStream1_Input ioStream1_Input = new IOStream1_Input();
			ioStream1_Input.open();
			ioStream1_Input.real_all();
		}
}
