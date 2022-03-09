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
		
		sortProcs(processes, "time");

		for (Process p : processes)
			System.out.println(p.toString());
		System.out.println("-----------------");

		doTheRest();

		for (Process p : processes)
			System.out.println(p.toString());
		System.out.println("-----------------");

		draw(processes); 

	}

	protected void doTheRest() {
		// for the first process, we can do it manually 
		Process p = processes.get(0);
		processes.get(0).setEnd( p.getArrival() + p.getTime());
		processes.get(0).setTotalTime();
		processes.get(0).setWait();
		
		// now for the rest
		// https://iq.opengenus.org/shortest-job-first-cpu-scheduling/
		int temp, value = 0;
		// int low
		for (int i = 1; i < processNum; i++) {
			temp = processes.get(i-1).getEnd();
			int low = processes.get(i).getTime();
			for (int j = i; j < processNum; i++) {
				if (temp >= processes.get(j).getArrival() && low >= processes.get(j).getTime()) {
					low = processes.get(j).getTime();
					value = j;
				}
			}
			processes.get(value).setEnd(temp + processes.get(value).getTime());
			processes.get(value).setTotalTime( processes.get(value).getEnd() - processes.get(value).getArrival());
			processes.get(value).setWait( processes.get(value).getTotalTime() - processes.get(value).getTime());
		}
	}

}
