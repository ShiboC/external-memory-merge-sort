import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MultiWayMerger {
	
	public void merge(List<String> fileName) throws IOException {
		
		List<IOStream2_Input> inputStream = new ArrayList<IOStream2_Input>();
		for (String string : fileName) {
			IOStream2_Input newInputStream = new IOStream2_Input(string); 
			newInputStream.open();
			inputStream.add(newInputStream);
		}		
		
		while(hasMoreData(inputStream)) {
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			for(IOStream2_Input i : inputStream) {
				if(!i.end_of_stream()) {
					pq.add(i.read_next());
				}
			}
			System.out.println("=====================");
			int count = pq.size();
			for(int k = 0; k < count; k++) {
				System.out.println(pq.poll());
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
