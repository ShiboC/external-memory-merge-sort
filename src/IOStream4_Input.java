import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class IOStream4_Input extends AbstractInputStream {
	private RandomAccessFile randomAccessFile;
	private FileChannel fileChannel;
	// the 'B' element portion of file in the assignment description
	private int bufferSize;
	// the current position in the file that need to be mapped
	private long filePosition;
	// A direct byte buffer whose content is a memory-mapped region of a file
	private MappedByteBuffer mappedByteBuffer;
	private String filePath;
	private long fileSize;
	private int bufferPosition;

	public IOStream4_Input(String filePath, int bElements) throws IOException {
		this.bufferSize = bElements * 4;
		this.filePosition = 0;
		this.filePath = filePath;
	}

	// map the file into the memory
	private void map() throws IOException {
		long mapSize = Math.min(fileSize - filePosition, bufferSize);
		if (filePosition < fileSize) {
			mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, filePosition, mapSize);
			filePosition += bufferSize;
		}
		resetBufferPosition();
	}

	@Override
	public void open() throws IOException {
		this.randomAccessFile = new RandomAccessFile(filePath, "r");
		this.fileChannel = randomAccessFile.getChannel();
		this.fileSize = fileChannel.size();
		this.bufferPosition = 0;
		map();
	}

	@Override
	public boolean end_of_stream() throws IOException {
		if (filePosition < fileSize || hasRemaining()) {
			return false;
		} else {
			return true;
		}
	}
	
	private boolean hasRemaining(){
		return (bufferPosition < bufferSize);
	}
	
	private void resetBufferPosition(){
		bufferPosition = 0;
	}

	@Override
	// check end_of_stream first then read_next
	public int read_next() throws IOException {
		//if the buffer is empty and the stream hasnt reach to the end, map new integers into the memory
		if (!end_of_stream() && !hasRemaining()) {
			map();
		}
		bufferPosition += 4;
		return mappedByteBuffer.getInt();
	}

	// main file for checking this implementation correctness
	public static void main(String[] args) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		int i = 1;
		int N = 10;
		int b = 3;
		
		String inputFile = "testInput0.data";
		String outputFile = "testOutput0.data";
		
		IOStream4_Input ioStream4Read = new IOStream4_Input(inputFile, b);
		ioStream4Read.open();
		IOStream4_Output ioStream4Write = new IOStream4_Output(outputFile, b, N);
		ioStream4Write.create();
		for (int j = 0; j < N; j++) {
			int temp = ioStream4Read.read_next();
			ioStream4Write.write(temp);
		}
		ioStream4Read.close();
		ioStream4Write.close();

		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		System.out.println("SystemTime & UserTime;" + elapsedSystemTimeUserTime[0]
				+ ";" + elapsedSystemTimeUserTime[1]);
	
	}

	@Override
	public void close() throws IOException {
		randomAccessFile.close();
	}

	@Override
	public ArrayList<Integer> read_all() throws IOException {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (!this.end_of_stream()) {
			Integer i=this.read_next();
			arrayList.add(i);
		}
		return arrayList;
	}

}
