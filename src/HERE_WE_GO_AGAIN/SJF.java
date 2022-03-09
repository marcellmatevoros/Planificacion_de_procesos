package HERE_WE_GO_AGAIN;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class SJF extends Scheduler {
	
	private LinkedList<Process> finalProcesses;
	
	SJF() throws Exception {
		super();
		// set the start and end times of each process

		for (Process p : processes)
			System.out.println(p.toString());

		/* settear estos atributos despues de settear los tiempos 'start' y 'end'
		 * de cada proceso
		setTotalTimes();
		setWaits();
		setPenalties();
		*/
		for (Process p : processes)
			System.out.println(p.toString());

		doit();
		draw(processes); 

	}

	protected void doit() {
		// for the 1st process
		processes.get(0).setStart( processes.get(0).getArrival() );
		processes.get(0).setEnd( processes.get(0).getArrival() + processes.get(0).getTime() );
		processes.get(0).setWait(0);

		Process current, candidate;
		ArrayList<Integer> indexQueue = new ArrayList<>();
		int priorProcessEnd = 0, lastExecuted = 0;
		for (int i = 1; i < processes.size(); i++) {
			current = processes.get(i);
			// look for processes that arrive before current process finishes
			for (int k = i; k < processes.size(); k++) {
				candidate = processes.get(k);
				// if process ahead of i arrives before current finishes
				if (candidate.getArrival() <= (current.getArrival() + current.getTime()))
					indexQueue.add(k); // add index of candidate to list
			}
			
			// with indexqueue, put (processes[i].time, index) in map
			// this will sort the worthy processes by time
			TreeMap<Integer,Integer> timeIndexMap = new TreeMap<>();
			for (Integer index : indexQueue)
				timeIndexMap.put( processes.get(index).getTime(), index);
				
			for (Integer index : timeIndexMap.values()) {
				priorProcessEnd = processes.get(lastExecuted).getArrival() + processes.get(lastExecuted).getTime();
				processes.get(index).setWait( priorProcessEnd - processes.get(index).getArrival() );
				processes.get(index).setEnd( processes.get(index).getArrival() +
											 processes.get(index).getWait() + 
											 processes.get(index).getTime());
				lastExecuted = index;
			}
		}
	}

}
