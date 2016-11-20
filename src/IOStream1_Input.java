import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class IOStream1_Input implements I_InputStream {
	
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

}
