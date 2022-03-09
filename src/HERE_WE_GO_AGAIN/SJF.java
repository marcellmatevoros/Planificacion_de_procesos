package HERE_WE_GO_AGAIN;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SJF extends Scheduler {
	
	private LinkedList<Process> finalProcesses;
	
	SJF() throws Exception {
		super();
		finalProcesses = new LinkedList<>();
		draw(processes);
		sortProcs(processes, "arrival");
	}

	protected void doit() {
		
	}

}
