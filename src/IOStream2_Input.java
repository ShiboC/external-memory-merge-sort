import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOStream2_Input implements I_InputStream {

	private InputStream is;
	private BufferedInputStream bis;
	private DataInputStream ds;
	
	@Override
	public void open(String filename) throws IOException {
		is = new FileInputStream( new File(filename) );
		bis = new BufferedInputStream( is );
		ds = new DataInputStream( bis );
	}

	@Override
	public boolean end_of_stream() throws IOException {
		if (ds.available()>0) 
			return false;
		
		return true;
	}

	@Override
	public int read_next() throws IOException {
		return ds.readInt();
	}

}
