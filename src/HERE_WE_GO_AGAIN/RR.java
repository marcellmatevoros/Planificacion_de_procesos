package HERE_WE_GO_AGAIN;

import java.util.ArrayList;
import java.util.LinkedList;

public class RR extends Scheduler {

	private int quantum;
	private int[] starts;
	private int[] ends;
	private int[] waits;

	RR() {
		System.out.println("Aun no ha sido implementado");
		/*
		super();
		this.quantum = askUser("Introduzca el quantum: ");
		starts = new int[processNum];
		ends = new int[processNum];
		waits = new int[processNum];

		doStuff();
		
		for (int i = 0; i < processNum; i++) {
			processes.get(i).setWait(waits[i]);
			processes.get(i).setTotalTime( processes.get(i).getTime() + waits[i]);
			processes.get(i).setPenalty();
		}
		
		sortProcs(processes, "arrival");
		for (Process p : processes) System.out.println( p.toString() );
		*/

		// LinkedList<Process> procs = doTheRest();
	}

	/**
	 * Iterates through the Process list and check if all of the Processes' 'done'
	 * attribute is set to true.
	 * 
	 * @param processes
	 * @return boolean
	 */
	protected boolean areDone(LinkedList<Process> processes) {
		for (Process p : processes)
			if (p.getDone() == false)
				return false;
		return true;
	}

	/**
	 * Returns a list of Processes that arrive before the process at position
	 * 'index' ends.
	 * 
	 * @param processes
	 * @param index
	 * @return candidates
	 */
	protected static LinkedList<Process> getCandidates(LinkedList<Process> processes, int index) {
		LinkedList<Process> candidates = new LinkedList<>();
		int endOfPreviousProcess = processes.get(index).getEnd();
		for (Process p : processes) {
			if (p.getArrival() <= endOfPreviousProcess && !p.getDone())
				candidates.add(p);
		}
		return candidates;
	}

	protected void doStuff() {
		int total;
		do {
			for (int i = 0; i < processNum; i++) {
				if (times[i] > quantum) {
					for (int j = 0; j < processNum; j++)
						if (j != i && times[j] != 0) 
							waits[j] += quantum;
					times[i] -= quantum;
				} else {
					for (int j = 0; j < processNum; j++)
						if (j != i && times[j] != 0) 
							waits[j] += times[i];
					times[i] = 0;
				}
			}
			total = 0;

			for (int i = 0; i < processNum; i++) total += times[i];

		} while (total != 0);

	}

	protected LinkedList<Process> doTheRest() {
		LinkedList<Process> procs = new LinkedList<>();
		LinkedList<Process> done = new LinkedList<>();
		procs = processes;

		int lastExecTime = 0;
		while (procs.size() != 0) {
			if (procs.peek().getTimeLeft() <= quantum) {
				procs.peek().setDone(true);
				procs.peek().setStart(lastExecTime);
				procs.peek().setEnd(lastExecTime + procs.peek().getTimeLeft());
				procs.peek().setTimeLeft(0);
				procs.peek().setTotalTime();
				procs.peek().setWait();
				procs.peek().setPenalty();
				lastExecTime = procs.peek().getEnd();
				System.out.println(procs.peek().toString());
				done.add(procs.poll()); // add the process to done and remove from procs
			} else {
				procs.peek().setTimeLeft(procs.peek().getTimeLeft() - quantum);
				lastExecTime += quantum;
				procs.offer(procs.poll()); // move to tail of list
			}
		}
		return done;
	}

}
