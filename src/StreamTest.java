import java.io.IOException;

public class StreamTest {

	public StreamTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// k,the number of streams to create;N,the number of times to
		// read/write;
		// b,the number of elements in buffer
		int k, N, b;
		// Object obj = Class.forName("IOStream1_input").newInstance();
		// test with parameter k=30,N=10000,b=10
		k = 30;
		N = 10000;
		b = 10;
		// testStream1(k,N);
		String inputFile = "E:\\DBSA Test Input Data\\testInput" + 1 + ".data";
		String outputFile = "E:\\DBSA Test Input Data\\testOutput" + 1 + ".data";

		IOStream2_Input ioStream2Read = new IOStream2_Input(inputFile);
		ioStream2Read.open();
		IOStream2_Output ioStream2Write = new IOStream2_Output(outputFile);
		ioStream2Write.create();
		int temp = ioStream2Read.read_next();
		ioStream2Read.close();
		System.out.println(temp);
		ioStream2Write.write(temp);
		ioStream2Write.close();

		System.out.println("end");
	}

	// run "one read&write"test n times to get the average cost

	/**
	 * 
	 * @param k the number of streams to create
	 * @param N the number of elements to read/write
	 * @param nn the number of times to run
	 * @return the average time of opening k streams to read and write N elements.
	 * @throws IOException
	 */
	public static long testStream1(int k, int N, int nn) throws IOException {
		Long start = System.nanoTime();
		for (int i = 0; i < k; i++) {
			String inputFile = "E:\\DBSA Test Input Data\\testInput" + i + ".data";
			String outputFile = "E:\\DBSA Test Input Data\\testOutput" + i + ".data";
			IOStream1_Input ioStream1Read = new IOStream1_Input(inputFile);
			ioStream1Read.open();
			IOStream1_Output ioStream1Write = new IOStream1_Output(outputFile);
			ioStream1Write.create();
			for (int j = 0; j < N; j++) {
				int temp = ioStream1Read.read_next();
				ioStream1Write.write(temp);
			}
			ioStream1Read.close();
			ioStream1Write.close();
		}
		Long end = System.nanoTime();
		return end - start;
	}

	public static Long testStream2(int k, int N) throws IOException {
		Long start = System.nanoTime();
		for (int i = 0; i < k; i++) {
			String inputFile = "E:\\DBSA Test Input Data\\testInput" + i + ".data";
			String outputFile = "E:\\DBSA Test Input Data\\testOutput" + i + ".data";
			IOStream2_Input ioStream2Read = new IOStream2_Input(inputFile);
			ioStream2Read.open();
			IOStream2_Output ioStream2Write = new IOStream2_Output(outputFile);
			ioStream2Write.create();
			for (int j = 0; j < N; j++) {
				int temp = ioStream2Read.read_next();
				ioStream2Write.write(temp);
			}
			ioStream2Read.close();
			ioStream2Write.close();
		}
		Long end = System.nanoTime();
		return end - start;
	}

	public static Long testStream3(int k, int N, int b) throws IOException {
		Long start = System.nanoTime();
		for (int i = 0; i < k; i++) {
			String inputFile = "E:\\DBSA Test Input Data\\testInput" + i + ".data";
			String outputFile = "E:\\DBSA Test Input Data\\testOutput" + i + ".data";
			IOStream3_Input ioStream3Read = new IOStream3_Input(inputFile, b);
			ioStream3Read.open();
			IOStream3_Output ioStream3Write = new IOStream3_Output(outputFile, b);
			ioStream3Write.create();
			for (int j = 0; j < N; j++) {
				int temp = ioStream3Read.read_next();
				ioStream3Write.write(temp);
			}
			ioStream3Read.close();
			ioStream3Write.close();
		}
		Long end = System.nanoTime();
		return end - start;
	}

	public static Long testStream4(int k, int N, int b) throws IOException {
		Long start = System.nanoTime();
		for (int i = 0; i < k; i++) {
			String inputFile = "E:\\DBSA Test Input Data\\testInput" + i + ".data";
			String outputFile = "E:\\DBSA Test Input Data\\testOutput" + i + ".data";
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
		}
		Long end = System.nanoTime();
		return end - start;
	}
}
