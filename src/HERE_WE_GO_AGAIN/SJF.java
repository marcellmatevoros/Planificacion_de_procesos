package HERE_WE_GO_AGAIN;

import java.util.LinkedList;

public class SJF extends Scheduler {
	
	SJF() throws Exception {
		super();
		sortProcs(processes, "arrival");
		doTheRest();
		sortProcs(processes, "ID");
		draw(processes); 
		printAverage(processes, "totalTime", "Tiempo total medio: ");
		printAverage(processes, "wait", "Tiempo de espera medio: ");
	}

	/**
	 * Returns a list of Processes that arrive before the process at position 
	 * 'index' ends.
	 * @param processes
	 * @param index
	 * @return candidates
	 */
	protected static LinkedList<Process> getCandidates (LinkedList<Process> processes, int index) {
		LinkedList<Process> candidates = new LinkedList<>();
		int endOfPreviousProcess = processes.get(index).getEnd();
		for (Process p : processes) {
			if (p.getArrival() <= endOfPreviousProcess && !p.getDone())
				candidates.add(p);
		} return candidates;
	}

	protected void doTheRest() throws Exception {
		Process first = processes.get(0);
		processes.get(0).setStart(first.getArrival());
		processes.get(0).setEnd( first.getArrival() + first.getTime());
		processes.get(0).setTotalTime();
		processes.get(0).setWait();
		processes.get(0).setPenalty();
		processes.get(0).setDone(true);
		
		LinkedList<Process> candidates, times;
		int[] history = new int[processNum];
		history[0] = 0;
		int id;

		for (int i = 1; i < processNum; i++) {
			candidates = getCandidates(processes, history[i-1]);
			times = getSortedList(candidates, "time");
			id = times.get(0).getID();
			for (int k = 0; k < processNum; k++) {
				if (processes.get(k).getID() == id) {
					history[i] = k; 
					processes.get(k).setStart(processes.get(history[i-1]).getEnd());
					processes.get(k).setEnd(processes.get(history[i-1]).getEnd() + processes.get(k).getTime());
					processes.get(k).setTotalTime();
					processes.get(k).setWait();
					processes.get(k).setPenalty();
					processes.get(k).setDone(true);
				}
			}
		}
	}

}
