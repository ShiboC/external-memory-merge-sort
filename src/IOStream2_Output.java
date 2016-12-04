import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOStream2_Output extends AbstractOutputStream {

	private OutputStream os;
	private BufferedOutputStream bos;
	private DataOutputStream ds;
	
	public IOStream2_Output(String filename){
		this.setTarget(filename);
	}
	
	@Override
	public void create() throws IOException {
		os = new FileOutputStream( new File(this.target) );
		bos = new BufferedOutputStream( os );
		ds = new DataOutputStream( bos );
	}

	@Override
	public void write(int data) throws IOException {
		ds.writeInt(data);
	}

	@Override
	public void close() throws IOException {
		try {
			if(ds != null) ds.close();
		} catch (IOException e) {
			
		}
		
		try {
			if(os != null) os.close();
		} catch (IOException e) {
			
		}		
	}

}
