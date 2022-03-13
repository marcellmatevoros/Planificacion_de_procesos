package HERE_WE_GO_AGAIN;

public class Process {
	
	private int arrival;
	private int time;
	private int totalTime;
	private int start;
	private int end;
	private int wait;
	private double penalty;
	private int ID;
	// only for Round Robin algorithm
	private boolean done;
	private int timeLeft;

	Process (int ID, int arrival, int time) {
		this.ID = ID;
		this.arrival = arrival;
		this.time = time;
	}
	
	Process (int ID, int arrival, int time, int wait) {
		this.ID = ID;
		this.arrival = arrival;
		this.time = time;
		this.wait = wait;
	}
	
	public int getArrival () {return this.arrival;}
	
	public int getTime () {return this.time;}
	
	public void setTime (int time) {this.time = time;}
	
	public int getStart () {return this.start;}

	public void setStart (int start) {this.start = start;}

	public int getEnd () {return this.end;}

	public void setEnd (int end) {this.end = end;}

	public int getWait () {return this.wait;}

	public void setWait (int wait) {this.wait = wait;}
	
	public void setWait() {this.wait = totalTime - time;}

	public int getTotalTime () {return this.totalTime;}

	public void setTotalTime (int totalTime) {this.totalTime = totalTime;}
	
	public void setTotalTime () {this.totalTime = end - arrival;}
	
	public void setPenalty (double penalty) {this.penalty = penalty;}
	
	public void setPenalty () {this.penalty = totalTime / time;}
	
	public double getPenalty () {return this.penalty;}
	
	public void setDone (boolean done) {this.done = done;}
	
	public boolean getDone () {return done;}
	
	public void setID (int ID) {this.ID = ID;}
	
	public int getID () {return ID;}
	
	public int getTimeLeft() {return timeLeft;}
	
	public void setTimeLeft (int timeLeft) {this.timeLeft = timeLeft;}
	
	public String toString() {
		return "PID: " + ID + "\n\tArrival: " + arrival + 
				"\n\tTime: " + time + "\n\tStart: " + start +
				"\n\tEnd: " + end + "\n\tTotalTime: " + totalTime +
				"\n\tPenalty: " + penalty + "\n\tWait: " + wait;
	}

}
