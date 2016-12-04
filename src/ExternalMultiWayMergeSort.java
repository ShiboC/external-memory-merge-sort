import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;

public class ExternalMultiWayMergeSort {

	private String filename; 
	private int M;
	private int d;
	private AbstractInputStream inputStream;
	private AbstractOutputStream outputStream;
	
	public ExternalMultiWayMergeSort(String filename, int M, int d, AbstractInputStream inputStream, AbstractOutputStream outputStream){
		this.filename = filename;
		this.M = M;
		this.d = d;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	public void read() throws IOException{
		PriorityQueue<Integer> sortedQ = new PriorityQueue<Integer>();
		inputStream.open();
		
		Integer temp = 0;
		while(!inputStream.end_of_stream()){
			for(int i = 0; i < M; i++){
				temp = inputStream.read_next();
				sortedQ.add(temp);
			}
			
			
		}
	}
}
