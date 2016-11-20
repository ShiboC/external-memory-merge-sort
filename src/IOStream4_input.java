import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class IOStream4_input implements I_InputStream {
	private RandomAccessFile randomAccessFile;
	private FileChannel fileChannel;
	// the 'B' element portion of file in the assignment description
	private int bufferSize;
	// the current position in the file that need to be mapped
	private long position;
	// A direct byte buffer whose content is a memory-mapped region of a file
	private MappedByteBuffer mappedByteBuffer;
	private String filePath;

	public IOStream4_input(String filePath, int bElements) throws IOException {
		this.bufferSize = bElements * 4;
		this.position = 0;
		this.filePath = filePath;
	}

	// map the file into the memory
	private void map() throws IOException {
		long mapSize = Math.min(fileChannel.size() - position, bufferSize);
		if (position < fileChannel.size()) {
			mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, mapSize);
			position += bufferSize;
		}

	}
	
	@Override
	public void open() throws IOException {
		this.randomAccessFile = new RandomAccessFile(filePath, "rw");
		this.fileChannel = randomAccessFile.getChannel();
		map();
	}

	@Override
	public boolean end_of_stream() throws IOException {
		if (position < fileChannel.size() || mappedByteBuffer.hasRemaining()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	// check end_of_stream first then read_next
	public int read_next() throws IOException {
		if (!end_of_stream() && !mappedByteBuffer.hasRemaining()) {
			map();
		}
		return mappedByteBuffer.getInt();
	}

	public static void main(String[] args) throws IOException {
		IOStream4_output ioStream4Write = new IOStream4_output("test.data", 5);
		ioStream4Write.create();
		ioStream4Write.write(3);
		IOStream4_input ioStream4Read = new IOStream4_input("test.data", 5);
		ioStream4Read.open();
		System.out.println(ioStream4Read.read_next());
	}

	@Override
	public ArrayList<Integer> read_all() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
