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
				4000000,8000000};
//		System.out.println("Stream 1. Increase the number of N using 1 stream");
//		for (int i = 0; i < 5; i++) {
//			averageTest1(1, N, 10);
//			N *= 10;
//		}
//		System.out.println("Stream 1. Increase the number of stream using N = 10000");
//		for (int i = 1; i <= 30; i++) {
//			averageTest1(i, 10000, 10);
//		}
//		System.out.println("Stream 2. Increase the number of N using 1 stream");
//		for (int i = 0; i < 10; i++) {
//			averageTest2(1, Narray[i], 10);
//		}
//		System.out.println("Stream 2. Increase the number of stream using N = 10000");
//		for (int i = 1; i <= 30; i++) {
//			averageTest2(i, 1000000, 10);
//		}
//		System.out.println("Stream 3. Increase the number of N using 1 stream 1 B");
//		N = 1; // 10000
//		for (int i = 0; i < 9; i++) {
//			averageTest3(1, Narray[i], 4096, 10);
////			N *= 10;
//		}
		System.out.println("Stream 3. Increase the number of B using 1 stream N = 10000");
		// B increase from 1 to 1000
		b = 64;
		for (int i = 1; i < 19; i++) {
			averageTest3(1, Narray[9], b, 10);
			b *= 2;
		}

//		System.out.println(
//				"Stream 3. Increase the number of stream using N = 10000 and B = 10000 (or the optimal value of B)");
//		for (int i = 1; i <= 30; i++) {
//			averageTest3(i, 1000000, 1000000, 10);
//		}
//		System.out.println("Stream 4. Increase the number of N using 1 stream 1 B");
////		N = 1; // 10000
//		for (int i = 0; i < 9; i++) {
//			averageTest4(1, Narray[i], 4096, 10);
////			N *= 10;
//		}
//		System.out.println("Stream 4. Increase the number of B using 1 stream N = 10000");
//		 B increase from 1 to 1000
//		b = 64; // 10000
//		for (int i = 0; i < 18; i++) {
//			averageTest4(1, Narray[9], b, 10);
//			b *= 2;
//		}
//		System.out.println(
//				"Stream 4. Increase the number of stream using N = 10000 and B = 10000 (or the optimal value of B)");
//		for (int i = 1; i <= 30; i++) {
//			averageTest4(i, 100000, 100000, 10);
//		}

		// averageTest2(1, 10, 10);
		// testStream1(3, 4);

		/*
		 * int i = 1; for (i = 2; i <= 3; i++) { IOStream2_Input ioStream2Read =
		 * new IOStream2_Input("E:\\DBSA Test Input Data\\testOutput" + i +
		 * ".data"); ioStream2Read.open(); ioStream2Read.read_all(); }
		 * IOStream2_Input io= new IOStream2_Input(
		 * "E:\\DBSA Test Input Data\\testOutput2.data"); io.open(); //for(int
		 * j=0;j<1;j++){ System.out.println("  start  "+io.read_next()); //}
		 */

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
