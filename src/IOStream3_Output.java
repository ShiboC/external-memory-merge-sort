import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class IOStream3_Output extends AbstractOutputStream {
	// Variables
	private OutputStream os;
	private DataOutputStream ds;
	private String fileName;
	private ArrayList<Integer> buffer;
	private int buffer_size;
	private int n_elements;
	
	// Constructors
	public IOStream3_Output(){
		this.setTarget("IOStream3_Output.data");
		buffer = new ArrayList<Integer>();
		buffer_size = 1;
	}
	
	public IOStream3_Output(String filename, int buffer_size, int n_elements){
		this.setTarget(filename);
		buffer = new ArrayList<Integer>();
		this.buffer_size = buffer_size;
		this.n_elements = n_elements;
	}
	
	// Methods
	@Override
	public void create() throws IOException {
		os = new FileOutputStream(new File(this.target));
		ds = new DataOutputStream(os);
	}
	
	@Override
	public void write(int data) throws IOException {
		if(buffer.size() < buffer_size){
			// if the buffer is not full, input the data into buffer
			buffer.add(data);
			n_elements--;
		} else {
			// else write the buffer into storage, then add the data into buffer
			while(buffer.size() > 0) {
				ds.writeInt(buffer.get(0));
				buffer.remove(0);
			}
			buffer.add(data);
			n_elements--;
		}
		
		// if the number of elements has been reached, write all data
		if(n_elements == 0){
			while(buffer.size() > 0) {
				ds.writeInt(buffer.get(0));
				buffer.remove(0);
			}
		}
	}
	
	@Override
	public void close() throws IOException {
		ds.close();
		os.close();
	}
}
