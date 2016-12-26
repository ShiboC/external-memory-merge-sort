import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class IOStream4_Output extends AbstractOutputStream {
	private RandomAccessFile randomAccessFile;
	private File file;
	private FileChannel fileChannel;
	// the buffer size of 'B' element portion of file in the assignment description
	private int bufferSize;
	// the current position in the file that need to be mapped
	private long filePosition;
	// A direct byte buffer whose content is a memory-mapped region of a file
	private MappedByteBuffer mappedByteBuffer;
	private String filePath;
	// specify the number of elements to write
	private long noToWrite;
	private long fileSize;
	private int bufferPosition;

	public IOStream4_Output(String filePath, int bElements, long noToWrite) throws IOException {
		this.bufferSize = bElements * 4;
		this.filePosition = 0;
		this.setTarget(filePath);
		this.noToWrite = noToWrite;
	}
	
	public int getBufferSize() {
		return bufferSize;
	}

	// map the file into the memory
	private void map(long bufferSize) throws IOException {
		mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, filePosition, bufferSize);
		filePosition += bufferSize;
		resetBufferPosition();
	}

	@Override
	public void write(int value) throws IOException {
		//if the buffer is empty, map new integers into the memory
		if (!hasRemaining()) {
			map(Math.min(bufferSize, noToWrite*4-filePosition));
		}
		mappedByteBuffer.putInt(value);
		bufferPosition += 4;
	}
	
	private boolean hasRemaining(){
		return (bufferPosition < bufferSize);
	}
	
	private void resetBufferPosition(){
		bufferPosition = 0;
	}

	@Override
	public void close() throws IOException {
		randomAccessFile.close();
	}

	@Override
	public void create() throws IOException {	
		// delete the file if there's an existing file
		// mandatory because random access file is not deleting existing file
		// random access file only modified the file
		this.file = new File(this.target);
		this.file.delete();
		this.randomAccessFile = new RandomAccessFile(this.target, "rw");
		this.fileChannel = randomAccessFile.getChannel();
		this.fileSize = fileChannel.size();
		this.bufferPosition = 0;
		map(Math.min(bufferSize, noToWrite*4));
	}
}
