import java.io.IOException;

public class StreamTest {

	public StreamTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//k,the number of streams to create;N,the number of times to read/write;
		//b,the number of elements in buffer
		int k,N,b;
		
		//test with parameter k=30,N=10000,b=10
	}
	
	public long testStream1(int k, int N) throws IOException {
		Long start=System.nanoTime();
		for(int i=0;i<k;i++){
			String inputFile="testInput"+i+".data";
			String outputFile="testOutput"+i+".data";
			for(int j=0;j<N;j++){
				IOStream1_Input ioStream1Read = new IOStream1_Input(inputFile);
				ioStream1Read.open();
				int temp=ioStream1Read.read_next();
				IOStream1_Output ioStream1Write = new IOStream1_Output(outputFile);
				ioStream1Write.create();
				ioStream1Write.write(temp);
			}	
		}
		Long end=System.nanoTime();
		return end-start;
	}
	
	public Long testStream2(int k, int N) throws IOException {
		Long start=System.nanoTime();
		for(int i=0;i<k;i++){
			String inputFile="testInput"+i+".data";
			String outputFile="testOutput"+i+".data";
			for(int j=0;j<N;j++){
				IOStream2_Input ioStream2Read = new IOStream2_Input(inputFile);
				ioStream2Read.open();
				int temp=ioStream2Read.read_next();
				IOStream2_Output ioStream2Write = new IOStream2_Output(outputFile);
				ioStream2Write.create();
				ioStream2Write.write(temp);
			}	
		}
		Long end=System.nanoTime();
		return end-start;
	}
	public Long testStream3(int k, int N, int b) throws IOException {
		Long start=System.nanoTime();
		for(int i=0;i<k;i++){
			String inputFile="testInput"+i+".data";
			String outputFile="testOutput"+i+".data";
			for(int j=0;j<N;j++){
				IOStream3_Input ioStream3Read = new IOStream3_Input(inputFile, b);
				ioStream3Read.open();
				int temp=ioStream3Read.read_next();
				IOStream3_Output ioStream3Write = new IOStream3_Output(outputFile, b);
				ioStream3Write.create();
				ioStream3Write.write(temp);
			}	
		}
		Long end=System.nanoTime();
		return end-start;
	}
	public Long testStream4(int k, int N, int b) throws IOException {
		Long start=System.nanoTime();
		for(int i=0;i<k;i++){
			String inputFile="testInput"+i+".data";
			String outputFile="testOutput"+i+".data";
			for(int j=0;j<N;j++){
				IOStream4_Input ioStream4Read = new IOStream4_Input(inputFile, b);
				ioStream4Read.open();
				int temp=ioStream4Read.read_next();
				IOStream4_Output ioStream4Write = new IOStream4_Output(outputFile, b, N);
				ioStream4Write.create();
				ioStream4Write.write(temp);
			}	
		}
		Long end=System.nanoTime();
		return end-start;
	}
}
