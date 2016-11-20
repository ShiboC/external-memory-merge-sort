import java.io.IOException;

public interface I_OutputStream {
	
	public void create() throws IOException;
	public void write(int data) throws IOException;
	public void close() throws IOException;
}
