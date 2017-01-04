import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {
	public List<Integer> input;
	private AbstractInputStream inputStream;
	private String outputPath = "result\\";
	private int streamBufferSize;
	private boolean debug;
	private long[] elapsedSystemTimeUserTime;

	public HeapSort(List<Integer> input) {
		this.input = input;
	}

	public PriorityQueue<Integer> sort1() {
		PriorityQueue<Integer> sorted = new PriorityQueue<>(input);

		return (PriorityQueue<Integer>) sorted;
	}

	public long[] getElapsedTime() {
		return elapsedSystemTimeUserTime;
	}

	public HeapSort(AbstractInputStream inputStream, String outputPath, int bufferSize, boolean debug) {
		this.outputPath = outputPath + "\\";
		File f = new File(outputPath);
		f.mkdir();
		this.inputStream = inputStream;
		this.streamBufferSize = bufferSize;
		this.debug = debug;
		this.elapsedSystemTimeUserTime = new long[2];
	}

	public void sort() throws IOException {
		long start[] = new long[2];
		start[0] = CPUUtils.getSystemTime();
		start[1] = CPUUtils.getUserTime();

		PriorityQueue<Integer> sorted = new PriorityQueue<Integer>();
		inputStream.open();
		int N = 0;// number of integers in the file
		while (!inputStream.end_of_stream()) {
			sorted.add(inputStream.read_next());
			N++;
		}
		String outputFile = outputPath + "-" + "heapsorted";
		IOStream4_Output outputStream = new IOStream4_Output(outputFile, streamBufferSize, N);
		outputStream.setTarget(outputFile);
		outputStream.create();

		PrintWriter writer = null;
		if (debug)
			writer = new PrintWriter(outputFile + ".normal", "UTF-8");

		// write priority queue into file
		while (!sorted.isEmpty()) {
			int x = sorted.poll();
			outputStream.write((int) x);
			if (debug)
				writer.println(x);
		}
		outputStream.close();
		if (debug)
			writer.close();
		inputStream.close();
		this.elapsedSystemTimeUserTime[1] = CPUUtils.getUserTime() - start[1];
		this.elapsedSystemTimeUserTime[0] = CPUUtils.getSystemTime() - start[0];
	}

	public static void main(String[] args) throws IOException {
		IOStream2_Input inputStream = new IOStream2_Input("input.data");
		inputStream.open();
		List<Integer> a = new ArrayList<Integer>();
		while (!inputStream.end_of_stream()) {
			a.add(inputStream.read_next());
		}

		inputStream.close();

		HeapSort b = new HeapSort(a);
		PriorityQueue<Integer> result = b.sort1();

		while (!result.isEmpty()) {
			System.out.println(result.remove());
		}

	}
}