
public class Process {
	
	protected int arrival;
	protected int time;
	protected int start;
	protected int end;
	protected int totalT;
	protected int wait;
	protected double penalty;
	// arrival, t, start end totalT wait penalty
	
	Process(int arrival, int time) {
		this.arrival = arrival;
		this.time = time;
		// initialized the other attributes to 0 get no errors while the algorithm classes are empty
		start = 0;
		end = 0;
		totalT = 0;
		wait = 0;
		penalty = 0.0;
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
