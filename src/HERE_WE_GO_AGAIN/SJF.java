package HERE_WE_GO_AGAIN;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SJF extends Scheduler {
	
	private LinkedList<Process> finalProcesses;
	
	SJF() throws Exception {
		super();
		// set the start and end times of each process
		
		for (Process p : processes)
			System.out.println(p.toString());
		
		sortProcs(processes, "arrival");


		/* settear estos atributos despues de settear los tiempos 'start' y 'end'
		 * de cada proceso
		setTotalTimes();
		setWaits();
		setPenalties();
		*/

		for (Process p : processes)
			System.out.println(p.toString());

		draw(processes); 

	}

	protected void doit() {
		
	}

}
