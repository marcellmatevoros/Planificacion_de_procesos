package HERE_WE_GO_AGAIN;

public class RR extends Scheduler {
	
	private int quantum;
	
	RR() {
		super();
		this.quantum = askUser("Introduzca el quantum: ");
	}
	
	void setQuantum (int quantum) {
		this.quantum = quantum;
	}
	
	int getQuantum() {
		return this.quantum;
	}

	void setDone(boolean done) {
		
	}

}
