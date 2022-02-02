
public class Process {
	
	private int arrival;
	private int t;
	private int start;
	private int end;
	private int totalT;
	private int wait;
	private double penalty;
	
	Process(int arrival, int t) {
		this.arrival = arrival;
		this.t = t;
		this.penalty = 0;
	}
	
	void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
	int getArrival() {
		return arrival;
	}
	
	void setTime(int t) {
		this.t = t;
	}
	
	int getTime() {
		return t;
	}
	
	void setStart(int start) {
		this.start = start;
	}
	
	int getStart() {
		return start;
	}
	
	void setEnd(int end) {
		this.end = end;
	}
	
	int getEnd() {
		return end;
	}
	
	void setTotalT(int totalT) {
		this.totalT = totalT;
	}
	
	int getTotalT() {
		return totalT;
	}

	void setWait(int wait) {
		this.wait = wait;
	}
	
	int getWait() {
		return wait;
	}
	
	void setPenalty() {
		penalty = totalT / t;
	}
	
	double getPenalty() {
		return penalty;
	}

}
