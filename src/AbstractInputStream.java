import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractInputStream {
	
	public abstract void open() throws IOException;
	public abstract boolean end_of_stream() throws IOException;
	public abstract int read_next() throws IOException;
	public abstract ArrayList<Integer> read_all() throws IOException;
	public abstract void close() throws IOException;
}
