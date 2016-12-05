import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MultiWayMerger {
	
	private List<? extends AbstractInputStream> inputStream;
	private AbstractOutputStream outputStream;
	
	public MultiWayMerger(List<? extends AbstractInputStream> inputStream, AbstractOutputStream outputStream) throws IOException {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.outputStream.create();
	}
	
	public void merge() throws IOException {		
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
			int streamRef = polled.getStreamRef();
			System.out.println(streamRef + " : " + polled.getData());
			if (!inputStream.get(streamRef).end_of_stream()) {
				pq.add(new Data(streamRef,inputStream.get(streamRef).read_next()));
			}
		}
		outputStream.close();
		for(AbstractInputStream i : inputStream) {
			i.close();
		}
	}
	
	private boolean hasMoreData(List<? extends AbstractInputStream> stream) throws IOException {
		for (AbstractInputStream ioStream2_Input : stream) {
			if(!ioStream2_Input.end_of_stream()) {
				return true;
			}
		}
		return false;
	}
}
