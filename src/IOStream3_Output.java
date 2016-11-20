import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class IOStream3_Output implements I_OutputStream {
	// Variables
	private OutputStream os;
	private DataOutputStream ds;
	private String fileName;
	private ArrayList<Integer> buffer;
	private int buffer_size;
	
	// Constructors
	public IOStream3_Output(){
		this.fileName = "IOStream3_Output.data";
		buffer = new ArrayList<Integer>();
		buffer_size = 1;
	}
	
	public IOStream3_Output(String fileName){
		this.fileName = fileName;
		buffer = new ArrayList<Integer>();
		buffer_size = 1;
	}
	
	public IOStream3_Output(int buffer_size){
		this.fileName = "IOStream3_Output.data";
		buffer = new ArrayList<Integer>();
		this.buffer_size = buffer_size;
	}
	
	// Methods
	@Override
	public void create() throws IOException {
		os = new FileOutputStream(new File(fileName));
		ds = new DataOutputStream(os);
	}
	
	@Override
	public void write(int data) throws IOException {
		int n = 0;
		
//		int counter = 0;
		// while there is an element that needs to be written
		while(n < data){
//			System.out.println(counter++ + " check more element");
			if(buffer.size() < buffer_size){
//				System.out.println(counter++ + " buffer available");
				// if buffer is available, add element into the buffer
				while(buffer.size() < buffer_size && n < data){
//					System.out.println(counter++ + " add element into buffer");
					buffer.add(n++);
				}
			}
			// else write element into storage
			else
			{
//				System.out.println(counter++ + " buffer not available");
				while(buffer.size() > 0) {
//					System.out.println(counter++ + " write element into storage");
					ds.writeInt(buffer.get(0));
//					System.out.println("Written Element: " + buffer.get(0));
					buffer.remove(0);
				}
			}
		}
		
		// write the remaining element in the buffer into storage
		while(buffer.size() > 0) {
//			System.out.println(counter++ + " last write element into storage");
			ds.writeInt(buffer.get(0));
//			System.out.println("Written Element: " + buffer.get(0));
			buffer.remove(0);
		}
	}
	
	@Override
	public void close() throws IOException {
		ds.close();
		os.close();
	}
	
}
