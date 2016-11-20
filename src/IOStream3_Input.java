import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class IOStream3_Input implements I_InputStream {
	
	// Variables
	private InputStream is;
	private DataInputStream ds;
	private String fileName;
	private ArrayList<Integer> buffer;
	private int buffer_size;
	private ArrayList<Integer> result;
	
	
	// Constructors
	public IOStream3_Input(){
		this.fileName = "IOStream3_Input.data";
		buffer = new ArrayList<Integer>();
		buffer_size = 1;
		result = new ArrayList<Integer>();
	}
	
	public IOStream3_Input(String filename){
		this.fileName = fileName;
		buffer = new ArrayList<Integer>();
		buffer_size = 1;
		result = new ArrayList<Integer>();
	}
	
	public IOStream3_Input(int buffer_size){
		this.fileName = "IOStream3_Input.data";
		buffer = new ArrayList<Integer>();
		this.buffer_size = buffer_size;
		result = new ArrayList<Integer>();
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
//		System.out.println is for debugging purpose
//		int counter = 0;
		// while there is an element in the stream
		while(!this.end_of_stream()){
//			System.out.println(counter++ + " check more element");
			// if buffer is available, add element into buffer
			if(buffer.size() < buffer_size){
//				System.out.println(counter++ + " buffer available");
				while(buffer.size() < buffer_size && !this.end_of_stream()){
					buffer.add(this.read_next());
//					System.out.println(counter++ + " add element into buffer");
				}
			} 
			// else add element into the result
			else {
//				System.out.println(counter++ + " buffer not available");
				while(buffer.size() > 0) {
//					System.out.println(counter++ + " add element into result");
					result.add(buffer.get(0));
					buffer.remove(0);
				}
			}
		}
		
		// add the remaining element in the buffer into result
		while(buffer.size() > 0) {
//			System.out.println(counter++ + " last add element into result");
			result.add(buffer.get(0));
			buffer.remove(0);
		}
		
		return result;
	}

	@Override
	public void close() throws IOException {
		ds.close();
		is.close();
	}

}
