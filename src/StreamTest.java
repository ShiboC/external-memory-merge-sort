import java.io.IOException;

public class StreamTest {

	private static String pathInput = "C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\testInput";
	private static String pathOutput = "C:\\Users\\pandu.wicaksono91\\Documents\\GitHub\\external-memory-merge-sort\\testOutput";
	
	public StreamTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		
		int N = 1; // 10000
		int b = 1; // 10000
		int Narray[] = {15625,31250,62500,
				125000,250000,500000,
				1000000,2000000,
				4000000,8000000,16000000,32000000};
		
		// Stream 1
		System.out.println("Stream 1. Increase the number of N using 1 stream");
//		for (int i = 0; i < 6; i++) {
//			averageTest1(1, Narray[i], 10);
//		}
		for (int i = 6; i <= 11; i++) {
			averageTest1(1, Narray[i], 1);
		}
		
//		N = Narray[5]; // 500,000
//		System.out.println("Stream 1. Increase the number of stream using N = " + N);
//		for (int i = 1; i <= 1; i++) {
//			averageTest1(i, N, 10);
//		}
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest1(i, N, 10);
//		}
		
		// Stream 2
		System.out.println("Stream 2. Increase the number of N using 1 stream");
//		for (int i = 0; i < 6; i++) {
//			averageTest2(1, Narray[i], 10);
//		}
		for (int i = 6; i <= 11; i++) {
			averageTest2(1, Narray[i], 1);
		}
		
//		N = Narray[5]; // 500,000
//		System.out.println("Stream 2. Increase the number of stream using N = " + N);
//		for (int i = 1; i <= 1; i++) {
//			averageTest2(i, N, 10);
//		}
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest2(i, N, 10);
//		}
		
		// Stream 3
		System.out.println("Stream 3. Increase the number of N using 1 stream 1 B");
//		for (int i = 0; i < 6; i++) {
//			averageTest3(1, Narray[i], 1, 10);
//		}
		for (int i = 6; i <= 11; i++) {
			averageTest3(1, Narray[i], 1, 1);
		}
		b = 2048;
		System.out.println("Stream 3. Increase the number of N using 1 stream B=" + b);
		b = 2048;
//		for (int i = 0; i < 6; i++) {
//			averageTest3(1, Narray[i], b, 10);
//		}
		for (int i = 6; i <= 11; i++) {
			averageTest3(1, Narray[i], b, 1);
		}
		
//		N = Narray[11]; // 500,000
//		System.out.println("Stream 3. Increase the number of B using 1 stream N = " + N);
//		b = 64;
//		for (int i = 0; i < 20; i++) {
//			averageTest3(1, N, b, 10);
//			b *= 2;
//		}

//		N = Narray[5]; // 500,000
//		b = 2048; // optimal value of B = 2,048
//		System.out.println(
//				"Stream 3. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 1; i <= 1; i++) {
//			averageTest3(i, N, b, 10);
//		}
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest3(i, N, b, 10);
//		}
		
		// Stream 4
//		System.out.println("Stream 4. Increase the number of N using 1 stream 1 B");
//		for (int i = 0; i < 6; i++) {
//			averageTest4(1, Narray[i], 1, 10);
//		}
		for (int i = 6; i <= 11; i++) {
			averageTest4(1, Narray[i], 1, 1);
		}
		
	
		System.out.println("Stream 4. Increase the number of N using 1 stream B=" + b);
		b = 32768;
//		for (int i = 0; i < 6; i++) {
//			averageTest4(1, Narray[i], b, 10);
//		}
		b = 8388608;
		for (int i = 6; i <= 11; i++) {
			averageTest4(1, Narray[i], b, 1);
		}
			
//		N = Narray[11]; // 500,000
//		System.out.println("Stream 4. Increase the number of B using 1 stream N = " + N);
//		b = 64; // 10000
//		for (int i = 0; i < 20; i++) {
//			averageTest4(1, N, b, 10);
//			b *= 2;
//		}
		
//		N = Narray[5]; // 500,000
//		b = 32768; // optimal value of B = 32768
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 1; i <= 1; i++) {
//			averageTest4(i, N, b, 10);
//		}
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest4(i, N, b, 10);
//		}
		
		// for large input
		// only applicable for stream 3 and 4
		// increase the number of B
//		N = Narray[11]; // 32,000,000
//		System.out.println("Stream 3. Increase the number of B using 1 stream N = " + N);
//		b = 512;
//		for (int i = 0; i < 17; i++) {
//			averageTest3(1, N, b, 10);
//			b *= 2;
//		}
		
//		N = Narray[11]; // 32,000,000
//		System.out.println("Stream 4. Increase the number of B using 1 stream N = " + N);
//		b = 512; // 10000
//		for (int i = 0; i < 17; i++) {
//			averageTest4(1, N, b, 10);
//			b *= 2;
//		}
//		
		// increase the number of k
//		N = Narray[11]; // 32,000,000
//		b = 2048;
//		System.out.println(
//				"Stream 3. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 1; i <= 1; i+=10) {
//			averageTest3(i, N, b, 10);
//		}
//		
//		N = Narray[11]; // 32,000,000
//		b = 2048;
//		System.out.println(
//				"Stream 3. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest3(i, N, b, 10);
//		}
		
//		N = Narray[11]; // 32,000,000
//		b = 32768; // optimal value of B = 8192
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 1; i <= 1; i+=10) {
//			averageTest4(i, N, b, 10);
//		}
		
//		N = Narray[11]; // 32,000,000
//		b = 8388608; // optimal value of B = 8192
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 10; i <= 30; i+=10) {
//			averageTest4(i, N, b, 10);
//		}
		
//		// increasing K while decreasing N
//		N = Narray[9]; // 2,000,000
//		b = 32768; // optimal value of B = 8192
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 1; i <= 1; i++) {
//			averageTest4(i, (N/i), b, 10);
//		}
//		
//		N = Narray[9]; // 2,000,000
//		b = 32768; // optimal value of B = 8192
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = "
//				+ N
//				+ " and B = "
//				+ b);
//		for (int i = 5; i <= 15; i+=5) {
//			averageTest4(i, (N/i), b, 10);
//		}
		
		
	}

	// run "one read&write"test n times to get the average cost
	/**
	 * 
	 * @param k
	 *            the number of streams to create
	 * @param N
	 *            the number of elements to read/write
	 * @param nn
	 *            the number of times to run
	 * @return the average time of opening k streams to read and write N
	 *         elements with implementation method1.
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static long[] averageTest1(int k, int N, int nn) throws IOException, InterruptedException {
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;
		
		for (int i = 0; i < nn; i++) {
			long result[] = testStream1(k, N);
			average[0] += result[0];
			average[1] += result[1];
			Thread.sleep(500);
		}
		average[0] /= nn;
		average[1] /= nn;
		System.out.println("Average time for Stream1 with kstream=" + k + 
				" Nelements="+ N + " times=" + nn + "(in SystemTime & UserTime);"
				+ average[0] + ";" + average[1] 
				);
		return average;
	}

	public static long[] averageTest2(int k, int N, int nn) throws IOException, InterruptedException {
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;
		
		for (int i = 0; i < nn; i++) {
			long result[] = testStream2(k, N);
			average[0] += result[0];
			average[1] += result[1];
			Thread.sleep(500);
		}
		average[0] /= nn;
		average[1] /= nn;
		System.out.println("Average time for Stream2 with kstream=" + k + " Nelements="
				+ N + " times=" + nn+ "(in SystemTime & UserTime);" 
				+ average[0] + ";" + average[1] 
				);
		return average;
	}

	public static long[] averageTest3(int k, int N, int b, int nn) throws IOException, InterruptedException {
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;
		for (int i = 0; i < nn; i++) {
			long result[] = testStream3(k, N, b);
			average[0] += result[0];
			average[1] += result[1];
			Thread.sleep(500);
		}
		average[0] /= nn;
		average[1] /= nn;
		System.out.println("Average time for Stream3 with kstream=" 
				+ k + " Nelements=" + N + " buffer=" + b + " times=" + nn 
				+ "(in SystemTime & UserTime);" 
				+ average[0] + ";" + average[1] );
		return average;
	}

	public static long[] averageTest4(int k, int N, int b, int nn) throws IOException, InterruptedException {
		long average[] = new long[2];
		average[0] = 0;
		average[1] = 0;
		for (int i = 0; i < nn; i++) {
			long result[] = testStream4(k, N, b);
			average[0] += result[0];
			average[1] += result[1];
			Thread.sleep(500);
		}
		average[0] /= nn;
		average[1] /= nn;
		System.out.println("Average time for Stream4 with kstream=" + k + " Nelements="
				+ N + " buffer=" + b + " times=" + nn + "(in SystemTime & UserTime);" 
				+ average[0] + ";" + average[1] );
		return average;
	}

	/**
	 * 
	 * @param k
	 *            the number of streams to create
	 * @param N
	 *            the number of elements to read/write
	 * @return the time(in milliseconds) of opening k streams to read and write
	 *         N elements.
	 * @throws IOException
	 */
	public static long[] testStream1(int k, int N) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		for (int i = 1; i <= k; i++) {
			String inputFile = pathInput + i + ".data";
			String outputFile = pathOutput + i + ".data";
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
		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		return elapsedSystemTimeUserTime;
	}

	public static long[] testStream2(int k, int N) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		for (int i = 1; i <= k; i++) {
			String inputFile = pathInput + i + ".data";
			String outputFile = pathOutput + i + ".data";
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
		
		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		return elapsedSystemTimeUserTime;
	}

	public static long[] testStream3(int k, int N, int b) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		for (int i = 1; i <= k; i++) {
			String inputFile = pathInput + i + ".data";
			String outputFile = pathOutput + i + ".data";
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
		
		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		return elapsedSystemTimeUserTime;
	}

	public static long[] testStream4(int k, int N, int b) throws IOException {
		long[] elapsedSystemTimeUserTime = new long[2];
		long[] start = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();
		
		for (int i = 1; i <= k; i++) {
			String inputFile = pathInput + i + ".data";
			String outputFile = pathOutput + i + ".data";
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
		
		elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
		
		return elapsedSystemTimeUserTime;
	}
}
