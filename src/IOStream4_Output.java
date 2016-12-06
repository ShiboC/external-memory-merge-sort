import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class IOStream4_Output extends AbstractOutputStream {
	private RandomAccessFile randomAccessFile;
	private FileChannel fileChannel;
	// the buffer size of 'B' element portion of file in the assignment description
	private int bufferSize;
	// the current position in the file that need to be mapped
	private int position;
	// A direct byte buffer whose content is a memory-mapped region of a file
	private MappedByteBuffer mappedByteBuffer;
	private String filePath;
	// specify the number of elements to write
	private int noToWrite;

	public IOStream4_Output(String filePath, int bElements, int noToWrite) throws IOException {
		this.bufferSize = bElements * 4;
		this.position = 0;
		this.setTarget(filePath);
		this.noToWrite = noToWrite;
	}

	// map the file into the memory
	private void map(int bufferSize) throws IOException {
		mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, position, bufferSize);
		position += bufferSize;
	}

	@Override
	public void write(int value) throws IOException {
		//if the buffer is empty, map new integers into the memory
		if (!mappedByteBuffer.hasRemaining()) {
			map(Math.min(bufferSize, noToWrite*4-position));
		}
		mappedByteBuffer.putInt(value);
	}

	@Override
	public void close() throws IOException {

		randomAccessFile.close();
	}

	@Override
	public void create() throws IOException {
		this.randomAccessFile = new RandomAccessFile(this.target, "rw");
		this.fileChannel = randomAccessFile.getChannel();
		
		map(Math.min(bufferSize, noToWrite*4));
	}

}
