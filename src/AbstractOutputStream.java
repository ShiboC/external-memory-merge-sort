import java.io.IOException;

public abstract class AbstractOutputStream {
	
	protected String target; // filename
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public abstract void create() throws IOException;
	public abstract void write(int data) throws IOException;
	public abstract void close() throws IOException;
}
