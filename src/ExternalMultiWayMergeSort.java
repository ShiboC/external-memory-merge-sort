import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalMultiWayMergeSort {

	private String filename; 
	private int M;
	private int d;
	private AbstractInputStream inputStream;
	private AbstractOutputStream outputStream1;
	private String path = "result\\";
	private List<String> sublist;
	
	public List<String> getSublist() {
		return sublist;
	}

	public ExternalMultiWayMergeSort(int M, int d, AbstractInputStream inputStream, AbstractOutputStream outputStream){
		File f = new File(path);
		f.mkdir();
		this.M = M;
		this.d = d;
		this.inputStream = inputStream;
		this.outputStream1 = outputStream;
	}
	
	public void read() throws IOException{
		List<String> outputFileName = new ArrayList<String>();
		PriorityQueue<Integer> sortedQ = new PriorityQueue<Integer>();
		inputStream.open();
		
		Integer temp = 0;
		int totalOutputStream = 0;
		while(!inputStream.end_of_stream()){
			System.out.println("======Start=======");
			for(int i = 0; i < M && !inputStream.end_of_stream(); i++){
				temp = inputStream.read_next();
				System.out.println(temp);
				sortedQ.add(temp);
			}
			
			String outputFile = "sorted" + totalOutputStream;
			IOStream2_Output outputStream = new IOStream2_Output(path + outputFile + ".data");
			PrintWriter writer = new PrintWriter(path + "sorted" + totalOutputStream + ".data.normal", "UTF-8");
			outputStream.create();
			
			while(!sortedQ.isEmpty()) {
				int x = sortedQ.poll();
				outputStream.write((int)x);
				writer.println(x);
			}
			outputStream.close();
			writer.close();
			
			outputFileName.add(outputFile);
			
			totalOutputStream++;
		}
		this.sublist = outputFileName;
		System.out.println(totalOutputStream);
	}
	
	public void merge(LinkedList<? extends AbstractInputStream> inputStream) throws IOException{
		int counter = 0;
		int subList = 0;
		int inputSize = inputStream.size();
		MultiWayMerger merger = null;
		
		List<IOStream2_Input> toMerge = null;
		LinkedList<IOStream2_Input> toMergeNext = new LinkedList<IOStream2_Input>();
		
		while(counter < inputSize) {
			toMerge = new ArrayList<IOStream2_Input>();
			for(int i = 0; i < d; i++) {
				if(!inputStream.isEmpty()) {
					toMerge.add((IOStream2_Input) inputStream.poll());
					counter++;
				}
			}
			
			subList++;
			
			String outputFile = subList + "sorted";
			merger = new MultiWayMerger(toMerge, new IOStream2_Output(outputFile));
			merger.merge();
			
			toMergeNext.add(new IOStream2_Input(outputFile));
		}
		
		if(subList > 1) {
			merge(toMergeNext);
		}
	}
}
