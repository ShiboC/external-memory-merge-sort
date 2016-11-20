import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class IOStream4_output implements I_OutputStream {
	private RandomAccessFile randomAccessFile;
	private FileChannel fileChannel;
	// the 'B' element portion of file in the assignment description
	private int bufferSize;
	// the current position in the file that need to be mapped
	private long position;
	// A direct byte buffer whose content is a memory-mapped region of a file
	private MappedByteBuffer mappedByteBuffer;
	private String filePath;

	public IOStream4_output(String filePath, int bElements) throws IOException {
		this.bufferSize = bElements * 4;
		this.position = 0;
		this.filePath = filePath;
	}
	
	// map the file into the memory
	private void map() throws IOException {
		mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, position, bufferSize);
		position += bufferSize;
	}

	@Override
	public void write(int value) throws IOException {
		if (!mappedByteBuffer.hasRemaining()) {
			map();
		}
		mappedByteBuffer.putInt(value);
	}

	@Override
	public void close() throws IOException {
		randomAccessFile.close();
	}

	@Override
	public void create() throws IOException {
		this.randomAccessFile = new RandomAccessFile(filePath, "rw");
		this.fileChannel = randomAccessFile.getChannel();
		map();
	}

}
