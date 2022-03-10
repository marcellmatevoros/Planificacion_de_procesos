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
		
		sortProcs(processes, "arrival");

		for (Process p : processes)
			System.out.println(p.toString());
		System.out.println("-----------------");

		doTheRest();

		for (Process p : processes)
			System.out.println(p.toString());
		System.out.println("-----------------");

		sortProcs(processes, "ID");
		draw(processes); 

	}

	protected void doTheRest() throws Exception {
		// for the first process, we can do it manually 
		Process first = processes.get(0);
		processes.get(0).setStart(first.getArrival());
		processes.get(0).setEnd( first.getArrival() + first.getTime());
		processes.get(0).setTotalTime();
		processes.get(0).setWait();
		processes.get(0).setDone(true);
		
		LinkedList<Process> candidates, times;
		int id;
		//then we will select processes that arrive before the first one ends
		for (int i = 1; i < processNum; i++) {
			candidates = getCandidates(processes, i-1);
			times = getSorted(candidates, "time");
			// pls work
			if (candidates.size() == 0 || times.size() == 0) break;
			id = times.get(0).getID();
			for (Process p : processes) {
				if (p.getID() == id) {
					p.setStart( processes.get(i-1).getEnd() );
					p.setEnd( processes.get(i-1).getEnd() + p.getTime() );
					p.setTotalTime();
					p.setWait();
					p.setPenalty();
					p.setDone(true);
				}
			}
		}
	}
	
	static LinkedList<Process> getCandidates (LinkedList<Process> processes, int index) {
		LinkedList<Process> candidates = new LinkedList<>();
		int endOfPreviousProcess = processes.get(index).getEnd();
		for (Process p : processes) {
			if (p.getArrival() <= endOfPreviousProcess && !p.getDone())
				candidates.add(p);
		} return candidates;
	}

}
