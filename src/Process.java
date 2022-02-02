
public class Process {
	
	private int arrival;
	private int time;
	
	Process(int arrival, int time) {
		this.arrival = arrival;
		this.time = time;
	}
	
	void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
	int getArrival() {
		return arrival;
	}
	
	void setTime(int time) {
		this.time = time;
	}
	
	int getTime() {
		return time;
	}
	
	

}
