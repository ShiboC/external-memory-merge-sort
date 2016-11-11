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
		int count=10;
		// TODO Auto-generated method stub
        RandomAccessFile memoryMappedFile = new RandomAccessFile("./src/largeFile.txt", "rw");


        // Mapping a file into memory
        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);


        // Writing into Memory Mapped File
        for (int i = 0; i < count; i++) {
            out.put((byte) 'B');
        }
        System.out.println("Writing to Memory Mapped File is completed");


        // reading from memory file in Java
        for (int i = 0; i < 10; i++) {
            System.out.print((char) out.get(i));
        }
        System.out.println("Reading from Memory Mapped File is completed");


        memoryMappedFile.close();
	}

}
