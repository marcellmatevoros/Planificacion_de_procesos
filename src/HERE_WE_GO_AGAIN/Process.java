package HERE_WE_GO_AGAIN;

public class Process {
	
	// mi clase Proceso --> estandart + comodidad
	private int arrival;
	private int time;
	private int totalTime;
	private int start;
	private int end;
	private int wait;
	private double penalty;
	private boolean done;
	private int ID;

	Process (int ID, int arrival, int time) {
		this.ID = ID;
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
	
	public void setID (int ID) {this.ID = ID;}
	
	public int getID () {return ID;}
	
	public String toString() {
		return "PID: " + ID + "\n\tArrival: " + arrival + 
				"\n\tTime: " + time + "\n\tStart: " + start +
				"\n\tEnd: " + end + "\n\tTotalTime: " + totalTime +
				"\n\tPenalty: " + penalty + "\n\tWait: " + wait;
	}

}
