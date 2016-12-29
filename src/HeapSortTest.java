import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSortTest {
	public List<Integer> input;
	
	public HeapSortTest(List<Integer> input) {
		this.input = input;
	}
	
	public PriorityQueue<Integer> sort(){
		PriorityQueue<Integer> sorted = new PriorityQueue<>(input);
		
		return (PriorityQueue<Integer>) sorted;
	}
	
	public static void main(String[] args) throws IOException {
		IOStream2_Input inputStream = new IOStream2_Input("input.data");
		inputStream.open();
		List<Integer> a = new ArrayList<Integer>();
		while(!inputStream.end_of_stream()) {
			a.add(inputStream.read_next());
		}
		
		inputStream.close();
		
		
		HeapSortTest b = new HeapSortTest(a);
		PriorityQueue<Integer> result = b.sort();
		
		while(!result.isEmpty()) {
			System.out.println(result.remove());
		}

	}
}
