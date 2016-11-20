import java.io.IOException;

public interface I_InputStream {
	
	public void open() throws IOException;
	public boolean end_of_stream() throws IOException;
	public int read_next() throws IOException;
	public void close() throws IOException;
}
