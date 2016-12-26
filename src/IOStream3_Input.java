import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class IOStream3_Input extends AbstractInputStream {
	
	// Variables
	private InputStream is;
	private BufferedInputStream bis;
	private DataInputStream ds;
	private String fileName;
	private int buffer_size;
	private ArrayList<Integer> result;
	
	
	// Constructors
	public IOStream3_Input(String filename, int buffer_size){
		this.buffer_size = buffer_size * 4;
		this.fileName = filename;
		result = new ArrayList<Integer>();
	}
	
	// Methods
	@Override
	public void open() throws IOException {
		is = new FileInputStream(new File (fileName));
		bis = new BufferedInputStream( is, buffer_size );
		
		ds = new DataInputStream( bis );
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
		
		while(!end_of_stream())
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
		
		IOStream3_Input ioStream3Read = new IOStream3_Input(inputFile, b);
		ioStream3Read.open();
		IOStream3_Output ioStream3Write = new IOStream3_Output(outputFile, b);
		ioStream3Write.create();
		for (int j = 0; j < N; j++) {
			int temp = ioStream3Read.read_next();
			ioStream3Write.write(temp);
		}
		ioStream3Read.close();
		ioStream3Write.close();

		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		System.out.println("SystemTime & UserTime;" + elapsedSystemTimeUserTime[0]
				+ ";" + elapsedSystemTimeUserTime[1]);
	
	}
}
