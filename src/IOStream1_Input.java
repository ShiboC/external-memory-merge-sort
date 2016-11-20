import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStream1_Input implements I_InputStream {
	private InputStream is;
	private DataInputStream ds;
	private String fileName;
	
	@Override
	public void open() throws IOException {
		fileName = "IOStream1_Input.data";
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
	
//	public void readFile(String fileName)
//	{
//		try{
//		
//		// read here
//		while(ds.available() > 0){
//			int a  = ds.readInt();
//			System.out.println(a);
//		}
//		
//		// write here
//		
//		// end time
//		// calculate time = end time - start time
//		// close the stream
//		ds.close();
//		
//		} catch (IOException e)
//		{
//			// do nothing
//		}
//	}
	
//	public void writeFile(String fileName, int n) throws IOException
//	{	
//		long startTimeNano = System.nanoTime();
//		long startTimeMilli = System.currentTimeMillis();
//		
//		OutputStream os = new FileOutputStream(new File(fileName));
//		DataOutputStream ds = new DataOutputStream(os);
//			
//		for(int ii = 0; ii < n; ii++)
//			ds.writeInt(ii);
//		
//		long endTimeNano = System.nanoTime();
//		long endTimeMilli = System.currentTimeMillis();
//		
//		long elapsedTimeNano = endTimeNano - startTimeNano;
//		long elapsedTimeMilli = endTimeMilli - startTimeMilli;
//		
//		System.out.println("Elapsed Time Nano: " + elapsedTimeNano);
//		System.out.println("Elapsed Time Milli: " + elapsedTimeMilli);
//		
////		System.out.println("Elapsed Time Difference: ");
//	}
}
