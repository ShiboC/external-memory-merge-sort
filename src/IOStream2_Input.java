import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class IOStream2_Input extends AbstractInputStream {

	private InputStream is;
	private BufferedInputStream bis;
	private DataInputStream ds;
	private String filename;
	
	public IOStream2_Input(String filename) {
		this.filename = filename;
	}
	
	@Override
	public void open() throws IOException {
		is = new FileInputStream( new File(filename) );
		bis = new BufferedInputStream( is );
		ds = new DataInputStream( bis );
	}

	@Override
	public boolean end_of_stream() throws IOException {
		if (ds.available() > 0) 
			return false;
		
		return true;
	}

	@Override
	public int read_next() throws IOException {
		return ds.readInt();
	}

	@Override
	public void close() throws IOException {
		try {
			if(is != null) is.close();
		} catch (IOException e) {
			
		}
		
		try {
			if(ds != null) ds.close();
		} catch (IOException e) {
			
		}		
	}

	@Override
	public ArrayList<Integer> read_all() throws IOException {
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!end_of_stream())
		{
			result.add(this.read_next());
		}
		return result;
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
		
		IOStream2_Input ioStream2Read = new IOStream2_Input(inputFile);
		ioStream2Read.open();
		IOStream2_Output ioStream2Write = new IOStream2_Output(outputFile);
		ioStream2Write.create();
		for (int j = 0; j < N; j++) {
			int temp = ioStream2Read.read_next();
			System.out.println(temp);
			ioStream2Write.write(temp);
		}
		ioStream2Read.close();
		ioStream2Write.close();

		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		System.out.println("SystemTime & UserTime;" + elapsedSystemTimeUserTime[0]
				+ ";" + elapsedSystemTimeUserTime[1]);
	
	}

}
