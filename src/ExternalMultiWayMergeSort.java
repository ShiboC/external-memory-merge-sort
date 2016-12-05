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
	private AbstractOutputStream outputStream;
	private String outputPath = "result\\";
	private List<String> sublist;
	
	public List<String> getSublist() {
		return sublist;
	}

	public ExternalMultiWayMergeSort(int M, int d, AbstractInputStream inputStream, AbstractOutputStream outputStream, String outputPath){
		this.outputPath = outputPath + "\\";
		File f = new File(outputPath);
		f.mkdir();
		this.M = M;
		this.d = d;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	public void sort() throws IOException{
		List<String> outputFileName = new ArrayList<String>();
		PriorityQueue<Integer> sortedQ = new PriorityQueue<Integer>();
		inputStream.open();
		
		Integer temp = 0;
		int totalOutputStream = 0;
		
		int pass = 0;
		
		while(!inputStream.end_of_stream()){
			for(int i = 0; i < M && !inputStream.end_of_stream(); i++){
				temp = inputStream.read_next();				
				sortedQ.add(temp);
			}
			
			String outputFile = outputPath + pass + "-" + totalOutputStream + "sorted";
			
			outputStream.setTarget(outputFile);
			
//			IOStream2_Output outputStream = new IOStream2_Output(path + outputFile);
			PrintWriter writer = new PrintWriter(outputFile + ".normal", "UTF-8");
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
		inputStream.close();
		this.sublist = outputFileName;
		
		LinkedList<IOStream2_Input> inputToMerge = new LinkedList<IOStream2_Input>();
		for (String s : sublist) {
			System.out.println(s);
			IOStream2_Input i = new IOStream2_Input(s);
			inputToMerge.add(i);
		}
		pass++;
		merge(inputToMerge,pass);
		System.out.println(totalOutputStream);
	}
	
	public void merge(LinkedList<? extends AbstractInputStream> inputStream, int pass) throws IOException{
		int counter = 0;
		int subList = 0;
		int inputSize = inputStream.size();
		MultiWayMerger merger = null;
		
		List<IOStream2_Input> toMerge = null;
		LinkedList<IOStream2_Input> toMergeNext = new LinkedList<IOStream2_Input>();
		
		for(AbstractInputStream i : inputStream) {
			i.open();
		}
		
		while(counter < inputSize) {
			toMerge = new ArrayList<IOStream2_Input>();
			for(int i = 0; i < d; i++) {
				if(!inputStream.isEmpty()) {
					toMerge.add((IOStream2_Input) inputStream.poll());
					counter++;
				}
			}
			
			subList++;
			
			String outputFile = outputPath + pass + "-"+ subList + "sorted";
			
//			System.out.println("ToMerge :" + toMerge.size());
//			System.out.println("Sublist :" + subList);
//			System.out.println(outputFile);
			merger = new MultiWayMerger(toMerge, new IOStream2_Output(outputFile), outputFile);
			merger.merge();
			
			toMergeNext.add(new IOStream2_Input(outputFile));
		}
		System.out.println("ToMergeNext Size : " + toMergeNext.size());
		
		if(subList > 1) {
			merge(toMergeNext, pass+1);
		}
	}
}
