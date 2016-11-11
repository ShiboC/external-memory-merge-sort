import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class IOStream4 {
	private RandomAccessFile randomAccessFile;
	private int bufferSize; //the 'B' element portion of file in the report
	private int position;
	private MappedByteBuffer mappedByteBuffer;
	
	private String filePath;
	public int read() {
		return mappedByteBuffer.getInt();
	}
	public void write(int value) {
		mappedByteBuffer.putInt(value); 
	}
	public void close() throws IOException{
		randomAccessFile.close();
	}


	public IOStream4(String filePath,int bufferSize) throws IOException {
		this.randomAccessFile = new RandomAccessFile(filePath, "rw");;
		this.bufferSize = bufferSize;
		this.position = 0;
		this.filePath = filePath;
		this.mappedByteBuffer=randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);
	}


	public static void main(String[] args) throws IOException {
		

	}

}
