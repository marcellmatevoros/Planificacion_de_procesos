import java.util.ArrayList;

public class RoundRobin extends Process {
	
	int quantum;
	ArrayList<Integer> remainders = new ArrayList<>();
	
	RoundRobin(int arrival, int time) {
		super(arrival, time);
	}
	
	RoundRobin(int arrival, int time, int quantum) {
		super(arrival, time);
		this.quantum = quantum;
	}
	
	void setStart(int[] starts, int[] ends) {
		// write your code here
	}
	
	void setEnd() {
		// write your code here
	}

	void setTotalT() {
		// write your code here
	}
	
	void setWait() {
		// write your code here
	}

	
}
