package HERE_WE_GO_AGAIN;

import java.util.ArrayList;
import java.util.LinkedList;

public class RR extends Scheduler {
	
	private int quantum;
	
	RR() throws Exception {
		super();
		this.quantum = askUser("Introduzca el quantum: ");

		for (Process p : processes) {
			p.setTimeLeft( p.getTime() );
			p.setDone(false);
		}
		sortProcs(processes, "arrival");

		LinkedList<Process> procs = doTheRest();
		/*
		for (Process p : procs) 
			System.out.println(p.toString());
		*/
	}
	
	/**
	 * Iterates through the Process list and check if all of the Processes' 
	 * 'done' attribute is set to true.
	 * @param processes
	 * @return boolean
	 */
	protected boolean areDone(LinkedList<Process> processes) {
		for (Process p : processes)
			if (p.getDone() == false) return false;
		return true;
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
	
	protected LinkedList<Process> doTheRest() {
		LinkedList<Process> procs = new LinkedList<>();
		LinkedList<Process> done = new LinkedList<>();
		procs = processes;

		int lastExecTime = 0;
		while (procs.size() != 0 ) {
			if (procs.peek().getTimeLeft() <= quantum) {
				procs.peek().setDone(true);
				procs.peek().setStart(lastExecTime);
				procs.peek().setEnd( lastExecTime + procs.peek().getTimeLeft() );
				procs.peek().setTimeLeft(0);
				procs.peek().setTotalTime();
				procs.peek().setWait();
				procs.peek().setPenalty();
				lastExecTime = procs.peek().getEnd();
				System.out.println(procs.peek().toString());
				done.add(procs.poll()); // add the process to done and remove from procs
			} else {
				procs.peek().setTimeLeft( procs.peek().getTimeLeft() - quantum );
				lastExecTime += quantum;
				procs.offer(procs.poll()); // move to tail of list
			}
		} return done;
		
	}
	
	/*
	protected void doTheRest() {
		LinkedList<Process> candidates;
		int lastExecTime = 0;
		while (!areDone(processes)) {
			for (Process p : processes) {
				if (p.getDone()) continue; // if it is done, skip it
				if (p.getTimeLeft() <= quantum) {
					p.setDone(true);
					p.setStart(lastExecTime);
					p.setEnd( lastExecTime + p.getTimeLeft() );
					p.setTimeLeft(0);
					p.setTotalTime();
					p.setWait();
					p.setPenalty();
					lastExecTime = p.getEnd();
				} else {
					p.setTimeLeft( p.getTimeLeft() - quantum );
					lastExecTime += quantum;
				}
			}
		}
	}
	*/

}
