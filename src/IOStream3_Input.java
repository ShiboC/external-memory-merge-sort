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

}
