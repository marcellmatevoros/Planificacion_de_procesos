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
	
	public int getArrival () {return this.arrival;}
	
	public int getTime () {return this.time;}
	
	public int getStart () {return this.start;}

	public void setStart (int start) {this.start = start;}

	public int getEnd () {return this.end;}

	public void setEnd (int end) {this.end = end;}

	public int getWait () {return this.wait;}

	public void setWait (int wait) {this.wait = wait;}
	
	public void setWait() {this.wait = totalTime - time;}

	public int getTotalTime () {return this.totalTime;}

	public void setTotalTime (int arrival) {this.arrival = arrival;}
	
	public void setTotalTime () {this.totalTime = end - arrival;}
	
	public void setPenalty (double penalty) {this.penalty = penalty;}
	
	public void setPenalty () {this.penalty = totalTime / time;}
	
	public double getPenalty () {return this.penalty;}
	
	public void setDone (boolean done) {this.done = done;}
	
	public boolean getDone () {return done;}
	
	public String toString() {
		int random = (int) (Math.random() * 1000);
		return "PID: " + random + "\n\tArrival: " + arrival + 
				"\n\tTime: " + time + "\n\tStart: " + start +
				"\n\tEnd: " + end + "\n\tTotalTime: " + totalTime +
				"\n\tPenalty: " + penalty + "\n\tWait: " + wait;
	}

}
