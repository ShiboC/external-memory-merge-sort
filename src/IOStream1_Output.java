import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOStream1_Output extends AbstractOutputStream {
	
	// Variables
	private OutputStream os;
	private DataOutputStream ds;
	private String fileName;
	
	// Constructors
	public IOStream1_Output(){
		this.fileName = "IOStream1_Output.data";
	}
	
	public IOStream1_Output(String fileName){
		this.fileName = fileName;
	}
	
	// Methods
	@Override
	public void create() throws IOException {
		os = new FileOutputStream(new File(fileName));
		ds = new DataOutputStream(os);
	}

	@Override
	public void write(int data) throws IOException {
		for(int ii = 0; ii < data; ii++)
			ds.writeInt(ii);
	}

	@Override
	public void close() throws IOException {
		ds.close();
		os.close();
	}

}
