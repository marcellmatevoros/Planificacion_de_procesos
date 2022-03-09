package HERE_WE_GO_AGAIN;

public class Process {
	
	private int arrival;
	private int time;
	private int totalTime;
	private int start;
	private int end;
	private int wait;
	private double penalty;
	private boolean done;

	Process (int arrival, int time) {
		this.arrival = arrival;
		this.time = time;
	}
	
	public int getArrival() {
		return this.arrival;
	}
	
	public int getTime() {
		return this.time;
	}
	
	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return this.end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWait() {
		return this.wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public int getTotalTime() {
		return this.totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
	public double getPenalty() {
		return this.penalty;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public boolean getDone() {
		return done;
	}
	
	public String toString() {
		return "[Arrival: " + arrival + "] [Time: " + time + "]";
	}

}
