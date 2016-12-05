
public class Data {
	private int streamRef ;
	private int data;
	
	public Data(int streamRef, int data) {
		this.streamRef = streamRef;
		this.data = data;
	}
	
	public int getStreamRef() {
		return streamRef;
	}
	public void setStreamRef(int streamRef) {
		this.streamRef = streamRef;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
