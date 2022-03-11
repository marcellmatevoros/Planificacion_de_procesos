package HERE_WE_GO_AGAIN;

import java.util.ArrayList;
import java.util.LinkedList;

public class RR extends Scheduler {
	
	private int quantum;
	ArrayList<String> graph;
	
	RR() throws Exception {
		super();
		this.quantum = askUser("Introduzca el quantum: ");
		graph = new ArrayList<>();
		sortProcs(processes, "arrival");

	}
	
	protected void setQuantum (int quantum) {this.quantum = quantum;}
	
	protected int getQuantum() {return this.quantum;}
	
	protected void doTheRest() {
		quantum = 5;
	}
	
	protected static void draw(LinkedList<Process> procs) {
		
	}
	
	
	
	

}
