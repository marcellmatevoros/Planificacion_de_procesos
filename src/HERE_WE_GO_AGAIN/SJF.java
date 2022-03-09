package HERE_WE_GO_AGAIN;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SJF extends Scheduler {
	
	private LinkedList<Process> finalProcesses;
	
	SJF() throws Exception {
		super();
		draw(processes);
		sortProcs(processes, "arrival");
		// set the start and end times of each process
		
		for (Process p : processes)
			System.out.println(p.toString());
		
		/*
		setTotalTimes();
		setWaits();
		setPenalties();
		*/

		draw(processes); 

		for (Process p : processes)
			System.out.println(p.toString());
	}

	protected void doit() {
		
	}

}
