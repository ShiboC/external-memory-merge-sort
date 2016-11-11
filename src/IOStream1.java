import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOStream1 {
	public void readFile(String fileName)
	{
		try{
		InputStream is = new FileInputStream(new File (fileName));
		DataInputStream ds = new DataInputStream(is);
		
		//while(ds.available() > 0){
			int a  = ds.readInt();
			System.out.println(a);
		//}
		
		// close the stream
		ds.close();
		
		} catch (IOException e)
		{
			// do nothing
		}
	}
}
