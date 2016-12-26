import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalMultiWayMergeSort {

	private int M;
	private int d;
	private AbstractInputStream inputStream;
	private String outputPath = "result\\";
	private List<String> sublist;
	private int streamBufferSize;
	private boolean debug;
	private long elapsedTime;
	
	public long getElapsedTime() {
		return elapsedTime;
	}

	public List<String> getSublist() {
		return sublist;
	}

	public ExternalMultiWayMergeSort(int M, int d, AbstractInputStream inputStream, String outputPath, int bufferSize, boolean debug){
		this.outputPath = outputPath + "\\";
		File f = new File(outputPath);
		f.mkdir();
		this.M = M;
		this.d = d;
		this.inputStream = inputStream;
		this.streamBufferSize = bufferSize;
		this.debug = debug;
	}
	
	public void sort() throws IOException{
		long start = CPUUtils.getSystemTime();
		
		List<String> outputFileName = new ArrayList<String>();
		PriorityQueue<Integer> sortedQ = new PriorityQueue<Integer>();
		inputStream.open();
		
		Integer temp = 0;
		int totalOutputStream = 0;
		
		int pass = 0;
		
		// first pass 
		System.out.println("=========First Pass=========");
		while(!inputStream.end_of_stream()){
			// split the big files into smaller chunks of size M
			for(int i = 0; i < M && !inputStream.end_of_stream(); i++){
				temp = inputStream.read_next();				
				sortedQ.add(temp);
			}

			String outputFile = outputPath + pass + "-" + totalOutputStream + "sorted";
			IOStream4_Output outputStream = new IOStream4_Output(outputFile, streamBufferSize, M);
			outputStream.setTarget(outputFile);
			outputStream.create();
			
			PrintWriter writer = null;
			if(debug) writer = new PrintWriter(outputFile + ".normal", "UTF-8");
			
			// write priority queue into file
			while(!sortedQ.isEmpty()) {
				int x = sortedQ.poll();
				outputStream.write((int)x);
				if(debug) writer.println(x);
			}
			outputStream.close();
			if(debug) writer.close();
			
			outputFileName.add(outputFile);
			
			totalOutputStream++;
		}
		inputStream.close();
		this.sublist = outputFileName;
		
		//group these chunks to be merged later
		LinkedList<IOStream4_Input> inputToMerge = new LinkedList<IOStream4_Input>();
		for (String s : sublist) {
			System.out.println(s);
			IOStream4_Input i = new IOStream4_Input(s, streamBufferSize);
			inputToMerge.add(i);
		}
		
		pass++;
		
		// merge recursively
		if(inputToMerge.size() > 1) {
			merge(inputToMerge,pass);
		}
		
		this.elapsedTime = CPUUtils.getSystemTime() - start;
	}
	
	public void merge(LinkedList<? extends AbstractInputStream> inputStream, int pass) throws IOException{
		System.out.println("=========Merging=========");
		int counter = 0;
		int subList = 0;
		int inputSize = inputStream.size();
		MultiWayMerger merger = null;
		
		List<IOStream4_Input> toMerge = null;
		LinkedList<IOStream4_Input> toMergeNext = new LinkedList<IOStream4_Input>();
		
		for(AbstractInputStream i : inputStream) {
			i.open();
		}
		
		while(counter < inputSize) {
			toMerge = new ArrayList<IOStream4_Input>();
			long fileSize = 0;
			for(int i = 0; i < d; i++) {
				
				// create d streams to merge d files in one pass, add to list
				if(!inputStream.isEmpty()) {
					IOStream4_Input input = (IOStream4_Input) inputStream.poll();
					fileSize+= input.getFileSize();
					toMerge.add(input);
					counter++;
				}
			}
			
			subList++;
			
			String outputFile = outputPath + pass + "-"+ subList + "sorted";
			
			System.out.println("OutputFile: " + outputFile);
			merger = new MultiWayMerger(toMerge, new IOStream4_Output(outputFile, streamBufferSize, fileSize/4), outputFile, debug);
			merger.merge();
			
			toMergeNext.add(new IOStream4_Input(outputFile, streamBufferSize));
		}
		System.out.println("Merging Pass " + pass + " Done! ToMergeNext : " + toMergeNext.size() + " file(s)");
		
		if(subList > 1) {
			merge(toMergeNext, pass+1);
		} 
	}
}
