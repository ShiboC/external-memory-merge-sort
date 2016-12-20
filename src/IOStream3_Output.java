import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOStream3_Output extends AbstractOutputStream {
	// Variables
	private OutputStream os;
	private BufferedOutputStream bos;
	private DataOutputStream ds;
	private int buffer_size;
	
	// Constructors	
	public IOStream3_Output(String filename, int buffer_size){
		this.setTarget(filename);
		this.buffer_size = buffer_size * 4;
	}
	
	// Methods
	@Override
	public void create() throws IOException {
		os = new FileOutputStream( new File(this.target) );
		bos = new BufferedOutputStream( os , buffer_size);
		ds = new DataOutputStream( bos );
	}
	
	@Override
	public void write(int data) throws IOException {
		ds.writeInt(data);
	}
	
	@Override
	public void close() throws IOException {
		ds.close();
		os.close();
	}
}
