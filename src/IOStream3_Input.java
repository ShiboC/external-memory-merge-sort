import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

public class IOStream3_Input implements I_InputStream {
	
	// Variables
	private InputStream is;
	private DataInputStream ds;
	private String fileName;
	private LinkedList<Integer> buffer;
	private int buffer_size;
	
	// Constructors
	public IOStream3_Input(){
		this.fileName = "IOStream3_Input.data";
		buffer = new LinkedList<Integer>();
		buffer_size = 1;
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
	public void real_all() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws IOException {
		ds.close();
		is.close();
	}

	

}
