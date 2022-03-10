package HERE_WE_GO_AGAIN;

public class FCFS extends Scheduler {
	
	FCFS() throws Exception {
		super();
		sortProcs(processes, "arrival");
		doTheRest();
		sortProcs(processes, "ID");
		draw(processes);
	}

	protected void doTheRest() {
		int[] history = new int[processNum];
		Process p, first, last;
		
		first = processes.get(0);
		processes.get(0).setStart( first.getArrival() );
		processes.get(0).setEnd( first.getArrival() + first.getTime() );
		processes.get(0).setTotalTime();
		processes.get(0).setWait();
		processes.get(0).setPenalty();

		for (int i = 1; i < processNum; i++) {
			p = processes.get(i);
			last = processes.get(i-1);
			processes.get(i).setStart( last.getEnd() );
			processes.get(i).setEnd( last.getEnd() + p.getTime() );
			processes.get(i).setTotalTime();
			processes.get(i).setWait();
			processes.get(i).setPenalty();
		}
	}

}
