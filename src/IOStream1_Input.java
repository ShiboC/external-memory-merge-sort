import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class IOStream1_Input extends AbstractInputStream {
	
	// Variables
	private InputStream is;
	private DataInputStream ds;
	private String fileName;
	private ArrayList<Integer> result;
	
	// Constructors
	public IOStream1_Input(){
		fileName = "IOStream1_Input.data";
		this.result = new ArrayList<Integer>();
	}
	
	public IOStream1_Input(String fileName){
		this.fileName = fileName;
	}
	
	// Methods
	@Override
	public void open() throws IOException {
		is = new FileInputStream(new File (fileName));
		ds = new DataInputStream(is);
	}

	@Override
	public boolean end_of_stream() throws IOException {
		return (ds.available() == 0);
	}

	@Override
	public int read_next() throws IOException {
		return (ds.readInt());
	}

	@Override
	public ArrayList<Integer> read_all() throws IOException {
		while(!this.end_of_stream())
		{
			result.add(this.read_next());
		}
		
		return result;
	}
	
	@Override
	public void close() throws IOException {
		ds.close();
		is.close();
	}
	
	// main file for checking this implementation correctness
	public static void main(String[] args) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		int i = 1;
		int N = 10;
		int b = 3;
		
		String inputFile = "testInput0.data";
		String outputFile = "testOutput0.data";
		
		IOStream1_Input ioStream1Read = new IOStream1_Input(inputFile);
		ioStream1Read.open();
		IOStream1_Output ioStream1Write = new IOStream1_Output(outputFile);
		ioStream1Write.create();
		for (int j = 0; j < N; j++) {
			int temp = ioStream1Read.read_next();
			ioStream1Write.write(temp);
		}
		ioStream1Read.close();
		ioStream1Write.close();

		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		System.out.println("SystemTime & UserTime;" + elapsedSystemTimeUserTime[0]
				+ ";" + elapsedSystemTimeUserTime[1]);
	
	}

}
