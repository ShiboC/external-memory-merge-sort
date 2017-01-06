import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MultiWayMerger {
	
	private List<? extends AbstractInputStream> inputStream;
	private AbstractOutputStream outputStream;
	private String filename;
	private boolean debug;
	
	public MultiWayMerger(List<? extends AbstractInputStream> inputStream, AbstractOutputStream outputStream, String filename, boolean debug) throws IOException {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.outputStream.create();
		this.filename = filename;
		this.debug = debug;
	}
	
	public void merge() throws IOException {	
		PrintWriter writer = null;
		if(debug) writer = new PrintWriter(filename + ".normal", "UTF-8");
		
		// Initialize a priority queue for the sorting purpose
		PriorityQueue<Data> pq = new PriorityQueue<Data>(inputStream.size(), new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				if(o1.getData() > o2.getData()) return 1;
				else if(o1.getData() < o2.getData()) return -1;
				return 0;
			} 
			
		});
		
		// Add first element of each stream to the priority queue
		for(int idx = 0; idx < inputStream.size(); idx++){
			if(!inputStream.get(idx).end_of_stream()) {
				pq.add(new Data(idx,inputStream.get(idx).read_next()));
			}
		}
		
		// Sort while inputStream or priority queue still has data 
		while(hasMoreData(inputStream) || pq.size() > 0) {
			Data polled = pq.poll();
			outputStream.write(polled.getData());
			if(debug) writer.println(polled.getData());
			int streamRef = polled.getStreamRef();
//			System.out.println(streamRef + " : " + polled.getData());
			if (!inputStream.get(streamRef).end_of_stream()) {
				pq.add(new Data(streamRef,inputStream.get(streamRef).read_next()));
			}
		}
		outputStream.close();
		if(debug) writer.close();
		for(AbstractInputStream i : inputStream) {
			i.close();
		}
	}
	
	private boolean hasMoreData(List<? extends AbstractInputStream> stream) throws IOException {
		for (AbstractInputStream ioStream_Input : stream) {
			if(!ioStream_Input.end_of_stream()) {
				return true;
			}
		}
		return false;
	}
}
