import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStream1 {
	public void readFile(String fileName)
	{
		try{
		InputStream is = new FileInputStream(new File (fileName));
		DataInputStream ds = new DataInputStream(is);
		
//		String s = ds.readLine();
//		start time
		// read here
		while(ds.available() > 0){
			int a  = ds.readInt();
			System.out.println(a);
		}
		
		// write here
		
		// end time
		// calculate time = end time - start time
		// close the stream
		ds.close();
		
		} catch (IOException e)
		{
			// do nothing
		}
	}
	
	public void writeFile(String fileName)
	{
		try
		{
			OutputStream os = new FileOutputStream(new File(fileName));
			DataOutputStream ds = new DataOutputStream(os);
			
			for(int ii = 0; ii <= 1000000; ii++)
				ds.writeInt(ii);
			
			
		}
		catch (IOException e)
		{
			
			
		}
		
	}
}
