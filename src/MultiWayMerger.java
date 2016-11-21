import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MultiWayMerger {
	
	public void merge(List<String> fileName) throws IOException {
		// Populate the List of input stream
		List<IOStream2_Input> inputStream = new ArrayList<IOStream2_Input>();
		for (String string : fileName) {
			IOStream2_Input newInputStream = new IOStream2_Input(string); 
			newInputStream.open();
			inputStream.add(newInputStream);
		}
		
		// Initialize a priority queue for the sorting purpose
		PriorityQueue<Data> pq = new PriorityQueue<Data>(fileName.size(), new Comparator<Data>() {

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
			int streamRef = polled.getStreamRef();
			System.out.println(streamRef + " : " + polled.getData());
			if (!inputStream.get(streamRef).end_of_stream()) {
				pq.add(new Data(streamRef,inputStream.get(streamRef).read_next()));
			}
		}
		
		for(IOStream2_Input i : inputStream) {
			i.close();
		}
	}
	
	private boolean hasMoreData(List<IOStream2_Input> stream) throws IOException {
		for (IOStream2_Input ioStream2_Input : stream) {
			if(!ioStream2_Input.end_of_stream()) {
				return true;
			}
		}
		return false;
	}
}
