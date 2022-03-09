package refactor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * For the Round Robin scheduling algorithm, only the start and end times must
 * be implemented.
 * 
 * also the diagram must be drawn
 * 
 * @author Senén Marqués
 * @date 8th March 2022
 */
public class RR extends Planner {

	private int quantum;
	private boolean[] done;
	private String[] procs;

	RR() {
		super();
		quantum = askUser("Introduzca el tiempo quantum: ");
		done = new boolean[processNum];
		procs = new String[processNum];
		for (String s : procs) s = "";
	}

	void setStarts() {
		// YOUR CODE HERE
		/*
		 * for (int i = 0; i < processNum; i++) { starts[i] = arrivals[i] + }
		 */
	}

	void setEnds() {
		// YOUR CODE HERE
	}

	void run() {
		
		while (!allTrue(done)) {
			for (int i = 0; i < processNum; i++) {
				if (done[i]) continue; // if that process is done, skip
				if (times[i] <= quantum) { // if the process is short enough
					done[i] = true;
					procs[i] += draw("-", arrivals[i]); // draw waiting time of process
					procs[i] += draw("*", times[i]); // draw execution time of process
				} else {
					done[i] = false;
					procs[i] += draw("")
				}

			}
		}
		
	}

	String draw(String s, int n) {
		String result = "";
		for (int i = 0; i < n; i++)
			result += s;
		return result;
	}

	/**
	 * Check if all the items in a boolean array are true
	 * 
	 * @param array - boolean array
	 * @return true if all items are set to true
	 */
	boolean allTrue(boolean[] array) {
		for (boolean bool : array)
			if (!bool)
				return false;
		return true;
	}

}
