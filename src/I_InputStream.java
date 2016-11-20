import java.io.IOException;
import java.util.ArrayList;

public interface I_InputStream {
	
	public void open() throws IOException;
	public boolean end_of_stream() throws IOException;
	public int read_next() throws IOException;
	public ArrayList<Integer> read_all() throws IOException;
	public void close() throws IOException;
}
